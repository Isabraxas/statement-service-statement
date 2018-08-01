package cc.viridian.service.statement.payload;

import cc.viridian.service.statement.persistence.StatementJob;
import java.time.LocalDateTime;
import java.util.Map;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Integer getErrorBankCode() {
        return errorBankCode;
    }

    public void setErrorBankCode(Integer errorBankCode) {
        this.errorBankCode = errorBankCode;
    }

    public String getErrorBankDesc() {
        return errorBankDesc;
    }

    public void setErrorBankDesc(String errorBankDesc) {
        this.errorBankDesc = errorBankDesc;
    }

    public Integer getErrorSendCode() {
        return errorSendCode;
    }

    public void setErrorSendCode(Integer errorSendCode) {
        this.errorSendCode = errorSendCode;
    }

    public String getErrorSendDesc() {
        return errorSendDesc;
    }

    public void setErrorSendDesc(String errorSendDesc) {
        this.errorSendDesc = errorSendDesc;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    public Integer getRetryNumber() {
        return retryNumber;
    }

    public void setRetryNumber(Integer retryNumber) {
        this.retryNumber = retryNumber;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimeEndJob() {
        return timeEndJob;
    }

    public void setTimeEndJob(LocalDateTime timeEndJob) {
        this.timeEndJob = timeEndJob;
    }

    public LocalDateTime getTimeStartJob() {
        return timeStartJob;
    }

    public void setTimeStartJob(LocalDateTime timeStartJob) {
        this.timeStartJob = timeStartJob;
    }

    public Jobs() {
    }

    public Jobs(StatementJob statementJob) {

        Map<String, Object> idMap = statementJob.getObjectId().getIdSnapshot();

        id = idMap.get("ID").toString();

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
