package cc.viridian.service.statement.persistence.auto;

import java.time.LocalDateTime;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _StatementJob was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _StatementJob extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final Property<String> ACCOUNT_CODE = Property.create("accountCode", String.class);
    public static final Property<String> ACCOUNT_CURRENCY = Property.create("accountCurrency", String.class);
    public static final Property<String> ACCOUNT_TYPE = Property.create("accountType", String.class);
    public static final Property<String> ADAPTER_COREBANK = Property.create("adapterCorebank", String.class);
    public static final Property<String> ADAPTER_FORMAT = Property.create("adapterFormat", String.class);
    public static final Property<String> ADAPTER_SEND = Property.create("adapterSend", String.class);
    public static final Property<String> CUSTOMER_CODE = Property.create("customerCode", String.class);
    public static final Property<Integer> ERROR_BANK_CODE = Property.create("errorBankCode", Integer.class);
    public static final Property<String> ERROR_BANK_DESC = Property.create("errorBankDesc", String.class);
    public static final Property<Integer> ERROR_SEND_CODE = Property.create("errorSendCode", Integer.class);
    public static final Property<String> ERROR_SEND_DESC = Property.create("errorSendDesc", String.class);
    public static final Property<String> FREQUENCY = Property.create("frequency", String.class);
    public static final Property<LocalDateTime> LOCAL_DATE_TIME = Property.create("localDateTime", LocalDateTime.class);
    public static final Property<String> PROCESS_DATE = Property.create("processDate", String.class);
    public static final Property<Integer> RETRY_NUMBER = Property.create("retryNumber", Integer.class);
    public static final Property<String> SEND_RECIPIENT = Property.create("sendRecipient", String.class);
    public static final Property<String> STATUS = Property.create("status", String.class);
    public static final Property<LocalDateTime> TIME_CREATE_JOB = Property.create("timeCreateJob", LocalDateTime.class);
    public static final Property<LocalDateTime> TIME_END_JOB = Property.create("timeEndJob", LocalDateTime.class);
    public static final Property<LocalDateTime> TIME_START_JOB = Property.create("timeStartJob", LocalDateTime.class);

    public void setAccountCode(String accountCode) {
        writeProperty("accountCode", accountCode);
    }
    public String getAccountCode() {
        return (String)readProperty("accountCode");
    }

    public void setAccountCurrency(String accountCurrency) {
        writeProperty("accountCurrency", accountCurrency);
    }
    public String getAccountCurrency() {
        return (String)readProperty("accountCurrency");
    }

    public void setAccountType(String accountType) {
        writeProperty("accountType", accountType);
    }
    public String getAccountType() {
        return (String)readProperty("accountType");
    }

    public void setAdapterCorebank(String adapterCorebank) {
        writeProperty("adapterCorebank", adapterCorebank);
    }
    public String getAdapterCorebank() {
        return (String)readProperty("adapterCorebank");
    }

    public void setAdapterFormat(String adapterFormat) {
        writeProperty("adapterFormat", adapterFormat);
    }
    public String getAdapterFormat() {
        return (String)readProperty("adapterFormat");
    }

    public void setAdapterSend(String adapterSend) {
        writeProperty("adapterSend", adapterSend);
    }
    public String getAdapterSend() {
        return (String)readProperty("adapterSend");
    }

    public void setCustomerCode(String customerCode) {
        writeProperty("customerCode", customerCode);
    }
    public String getCustomerCode() {
        return (String)readProperty("customerCode");
    }

    public void setErrorBankCode(int errorBankCode) {
        writeProperty("errorBankCode", errorBankCode);
    }
    public int getErrorBankCode() {
        Object value = readProperty("errorBankCode");
        return (value != null) ? (Integer) value : 0;
    }

    public void setErrorBankDesc(String errorBankDesc) {
        writeProperty("errorBankDesc", errorBankDesc);
    }
    public String getErrorBankDesc() {
        return (String)readProperty("errorBankDesc");
    }

    public void setErrorSendCode(int errorSendCode) {
        writeProperty("errorSendCode", errorSendCode);
    }
    public int getErrorSendCode() {
        Object value = readProperty("errorSendCode");
        return (value != null) ? (Integer) value : 0;
    }

    public void setErrorSendDesc(String errorSendDesc) {
        writeProperty("errorSendDesc", errorSendDesc);
    }
    public String getErrorSendDesc() {
        return (String)readProperty("errorSendDesc");
    }

    public void setFrequency(String frequency) {
        writeProperty("frequency", frequency);
    }
    public String getFrequency() {
        return (String)readProperty("frequency");
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        writeProperty("localDateTime", localDateTime);
    }
    public LocalDateTime getLocalDateTime() {
        return (LocalDateTime)readProperty("localDateTime");
    }

    public void setProcessDate(String processDate) {
        writeProperty("processDate", processDate);
    }
    public String getProcessDate() {
        return (String)readProperty("processDate");
    }

    public void setRetryNumber(int retryNumber) {
        writeProperty("retryNumber", retryNumber);
    }
    public int getRetryNumber() {
        Object value = readProperty("retryNumber");
        return (value != null) ? (Integer) value : 0;
    }

    public void setSendRecipient(String sendRecipient) {
        writeProperty("sendRecipient", sendRecipient);
    }
    public String getSendRecipient() {
        return (String)readProperty("sendRecipient");
    }

    public void setStatus(String status) {
        writeProperty("status", status);
    }
    public String getStatus() {
        return (String)readProperty("status");
    }

    public void setTimeCreateJob(LocalDateTime timeCreateJob) {
        writeProperty("timeCreateJob", timeCreateJob);
    }
    public LocalDateTime getTimeCreateJob() {
        return (LocalDateTime)readProperty("timeCreateJob");
    }

    public void setTimeEndJob(LocalDateTime timeEndJob) {
        writeProperty("timeEndJob", timeEndJob);
    }
    public LocalDateTime getTimeEndJob() {
        return (LocalDateTime)readProperty("timeEndJob");
    }

    public void setTimeStartJob(LocalDateTime timeStartJob) {
        writeProperty("timeStartJob", timeStartJob);
    }
    public LocalDateTime getTimeStartJob() {
        return (LocalDateTime)readProperty("timeStartJob");
    }

}
