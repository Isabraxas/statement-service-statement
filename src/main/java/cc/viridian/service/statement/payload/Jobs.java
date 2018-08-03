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
public class Jobs {

    private String id;

    private String accountCode;
    //private String accountCurrency;
    //private String accountType;
    //private String customerCode;
    //private String customerName;
    private Integer errorBankCode;
    private String errorBankDesc;
    private Integer errorSendCode;
    private String errorSendDesc;
    private String frequency;
    private LocalDateTime localDateTime;
    private String processDate;
    private Integer retryNumber;
    private Integer sendId;
    private String status;
    private LocalDateTime timeEndJob;
    private LocalDateTime timeStartJob;

    public Jobs(StatementJob statementJob) {
        id = Cayenne.pkForObject(statementJob).toString();
        accountCode = statementJob.getAccountCode();
        errorBankCode = statementJob.getErrorBankCode();
        errorBankDesc = statementJob.getErrorBankDesc();
        errorSendCode = statementJob.getErrorSendCode();
        errorSendDesc = statementJob.getErrorSendDesc();
        frequency = statementJob.getFrequency();
        localDateTime = statementJob.getLocalDateTime();
        processDate = statementJob.getProcessDate();
        retryNumber = statementJob.getRetryNumber();
        sendId = statementJob.getSendId();
        status = statementJob.getStatus();
        timeEndJob = statementJob.getTimeEndJob();
        timeStartJob = statementJob.getTimeStartJob();
    }
}
