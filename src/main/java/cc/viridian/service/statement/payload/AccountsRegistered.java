package cc.viridian.service.statement.payload;

import cc.viridian.service.statement.persistence.StatementMain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
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
