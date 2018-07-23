package cc.viridian.service.statement.payload;

import cc.viridian.service.statement.persistence.StatementMain;
import java.time.LocalDateTime;
import java.util.Map;

public class AccountsRegistered {

    private String id;

    private String accountCode;
    private String accountCurrency;
    private String accountType;
    private String customerCode;
    private String customerName;
    private Boolean enabled;
    private Integer fkFormat;
    private Integer fkSend;
    private String frequency;
    private Boolean overwrittenByBank;
    private LocalDateTime timeCreate;
    private LocalDateTime timeModify;
    private String usrCreate;
    private String usrModify;

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

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getFkFormat() {
        return fkFormat;
    }

    public void setFkFormat(Integer fkFormat) {
        this.fkFormat = fkFormat;
    }

    public Integer getFkSend() {
        return fkSend;
    }

    public void setFkSend(Integer fkSend) {
        this.fkSend = fkSend;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Boolean getOverwrittenByBank() {
        return overwrittenByBank;
    }

    public void setOverwrittenByBank(Boolean overwrittenByBank) {
        this.overwrittenByBank = overwrittenByBank;
    }

    public LocalDateTime getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(LocalDateTime timeCreate) {
        this.timeCreate = timeCreate;
    }

    public LocalDateTime getTimeModify() {
        return timeModify;
    }

    public void setTimeModify(LocalDateTime timeModify) {
        this.timeModify = timeModify;
    }

    public String getUsrCreate() {
        return usrCreate;
    }

    public void setUsrCreate(String usrCreate) {
        this.usrCreate = usrCreate;
    }

    public String getUsrModify() {
        return usrModify;
    }

    public void setUsrModify(String usrModify) {
        this.usrModify = usrModify;
    }

    public AccountsRegistered() {
    }

    public AccountsRegistered(StatementMain statementMain) {
        Map<String, Object> idMap = statementMain.getObjectId().getIdSnapshot();

        id = idMap.get("ID").toString();

        accountCode = statementMain.getAccountCode();
        accountCurrency = statementMain.getAccountCurrency();
        accountType = statementMain.getAccountType();
        customerCode = statementMain.getCustomerCode();
        customerName = statementMain.getCustomerName();
        enabled = statementMain.isEnabled();
        fkFormat = statementMain.getFkFormat();
        fkSend = statementMain.getFkSend();
        frequency = statementMain.getFrequency();
        overwrittenByBank = statementMain.isOverwrittenByBank();
        timeCreate = statementMain.getTimeCreate();
        timeModify = statementMain.getTimeModify();
        usrCreate = statementMain.getUsrCreate();
        usrModify = statementMain.getUsrModify();

    }
}
