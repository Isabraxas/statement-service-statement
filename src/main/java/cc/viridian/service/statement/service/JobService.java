package cc.viridian.service.statement.service;

import cc.viridian.service.statement.payload.*;
import cc.viridian.service.statement.persistence.StatementJob;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.cayenne.Cayenne;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.EJBQLQuery;
import org.apache.cayenne.query.ObjectSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@NoArgsConstructor
@Component
public class JobService {

    @Autowired
    ServerRuntime mainServerRuntime;

    @Autowired
    private KafkaTemplate<String, JobTemplate> kafkaTemplate;

    public ListJobsResponse listJobs(Integer start, Integer length)
    {
        ObjectContext context = mainServerRuntime.newContext();

        //Select all statement
        List<StatementJob> jobs = ObjectSelect.query(StatementJob.class)
            .limit(length)
            .offset(start)
            .select(context);

        List<ListJobs> jobsRegistered = new ArrayList<>();

        Iterator<StatementJob> it = jobs.iterator();
        while (it.hasNext()) {
            jobsRegistered.add(new ListJobs(it.next()) );
        }

        ListJobsResponse response = new ListJobsResponse();
        response.setData(jobsRegistered);

        response.setRecordsFiltered( countAllJobs() );
        response.setRecordsTotal(countAllJobs());

        return response;
    }

    public Long countAllJobs ()
    {
        ObjectContext context = mainServerRuntime.newContext();

        //Select count(*) from statement_main
        EJBQLQuery query = new EJBQLQuery("select count(job) from StatementJob job");
        List<Long> result = context.performQuery(query);

        return result.get(0);
    }

    public String registerSingleJob(PostRegisterJob body) {


        //save in database
        //place in kafka

        ObjectContext context = mainServerRuntime.newContext();
        StatementJob statementJob = context.newObject(StatementJob.class);

        statementJob.setAccountCode(body.getAccount());
        statementJob.setAccountCurrency(body.getCurrency());
        statementJob.setAccountType(body.getType());
        statementJob.setFrequency(body.getFrequency());
        statementJob.setCustomerCode(body.getCustomerCode());
        statementJob.setSendRecipient(body.getRecipient());
        statementJob.setAdapterCorebank(body.getCoreBankAdapter());
        statementJob.setAdapterFormat(body.getFormatAdapter());
        statementJob.setAdapterSend(body.getSendAdapter());

        statementJob.setErrorBankCode(0);
        statementJob.setErrorBankDesc("");
        statementJob.setErrorSendCode(0);
        statementJob.setErrorSendDesc("");

        statementJob.setLocalDateTime(LocalDateTime.now());
        statementJob.setProcessDate("201807"); //todo: fix
        statementJob.setRetryNumber(0);
        statementJob.setStatus("OPEN");

        statementJob.setTimeCreateJob(LocalDateTime.now());
        statementJob.setTimeEndJob(null);
        statementJob.setTimeStartJob(null);

        context.commitChanges();
        String id = Cayenne.pkForObject(statementJob).toString();


        JobTemplate jobTemplate = new JobTemplate(statementJob);

        Message<JobTemplate> message = MessageBuilder
            .withPayload(jobTemplate)
            .setHeader(KafkaHeaders.MESSAGE_KEY, id)
            .build();

        kafkaTemplate.send(message);

        return body.getAccount();
    }

    /*
    private KafkaMessageListenerContainer<Integer, String> createContainer(
        ContainerProperties containerProps) {
        Map<String, Object> props = consumerProps();
        DefaultKafkaConsumerFactory<Integer, String> cf =
            new DefaultKafkaConsumerFactory<Integer, String>(props);
        KafkaMessageListenerContainer<Integer, String> container =
            new KafkaMessageListenerContainer<>(cf, containerProps);
        return container;
    }
    */



}
