package cc.viridian.service.statement.service;

import cc.viridian.service.statement.payload.*;
import cc.viridian.service.statement.persistence.StatementJob;
import cc.viridian.service.statement.persistence.StatementMain;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.EJBQLQuery;
import org.apache.cayenne.query.ObjectSelect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class JobService {
    private static final Logger log = LoggerFactory.getLogger(JobService.class);

    @Autowired
    ServerRuntime mainServerRuntime;

    public String registerNewJob(PostRegisterJob body) {
        //String accountCurrency = body.getCurrency();
        String accountNumber = "abc"; //body.getAccount();
        //String accountType = body.getType();

        ObjectContext context = mainServerRuntime.newContext();
        StatementJob statementJob = context.newObject(StatementJob.class);

        statementJob.setAccountCode(accountNumber);
        statementJob.setErrorBankCode(0);
        statementJob.setErrorBankDesc("description");
        statementJob.setErrorSendCode(0);
        statementJob.setErrorSendDesc("send description");
        statementJob.setFrequency("DAI");
        statementJob.setLocalDateTime(LocalDateTime.now());
        statementJob.setProcessDate("201802");
        statementJob.setRetryNumber(0);
        statementJob.setSendId(0);
        statementJob.setStatus("open");
        statementJob.setTimeEndJob(null);
        statementJob.setTimeStartJob(null);

        context.commitChanges();
        return accountNumber;
    }


    public ListJobsResponse listJobs(Integer start, Integer length)
    {
        ObjectContext context = mainServerRuntime.newContext();

        //Select all statement
        List<StatementJob> jobs = ObjectSelect.query(StatementJob.class)
            .limit(length)
            .offset(start)
            .select(context);

        List<Jobs> jobsRegistered = new ArrayList<>();

        Iterator<StatementJob> it = jobs.iterator();
        while (it.hasNext()) {
            jobsRegistered.add(new Jobs(it.next()) );
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

}
