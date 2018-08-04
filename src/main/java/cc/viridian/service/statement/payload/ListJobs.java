package cc.viridian.service.statement.payload;

import cc.viridian.service.statement.persistence.StatementJob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.cayenne.Cayenne;
import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ListJobs {

    private String id;

    private String accountCode;
    private String accountCurrency;
    private String accountType;
    private String customerCode;
    private Integer errorBankCode;
    private String errorBankDesc;
    private Integer errorSendCode;
    private String errorSendDesc;
    private String frequency;
    private LocalDateTime localDateTime;
    private String processDate;
    private Integer retryNumber;
    private String send;
    private String format;
    private String corebank;
    private String status;
    private LocalDateTime timeCreateJob;
    private LocalDateTime timeEndJob;
    private LocalDateTime timeStartJob;

    public ListJobs(StatementJob statementJob) {
        id = Cayenne.pkForObject(statementJob).toString();
        accountCode = statementJob.getAccountCode();
        accountCurrency = statementJob.getAccountCurrency();
        accountType = statementJob.getAccountType();
        customerCode = statementJob.getCustomerCode();
        errorBankCode = statementJob.getErrorBankCode();
        errorBankDesc = statementJob.getErrorBankDesc();
        errorSendCode = statementJob.getErrorSendCode();
        errorSendDesc = statementJob.getErrorSendDesc();
        frequency = statementJob.getFrequency();
        localDateTime = statementJob.getLocalDateTime();
        processDate = statementJob.getProcessDate();
        retryNumber = statementJob.getRetryNumber();
        send = statementJob.getAdapterSend();
        format = statementJob.getAdapterFormat();
        corebank = statementJob.getAdapterCorebank();
        status = statementJob.getStatus();
        timeCreateJob = statementJob.getTimeCreateJob();
        timeEndJob = statementJob.getTimeEndJob();
        timeStartJob = statementJob.getTimeStartJob();
    }
}
