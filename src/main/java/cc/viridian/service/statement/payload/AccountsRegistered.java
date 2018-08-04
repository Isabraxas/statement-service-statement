package cc.viridian.service.statement.payload;

import cc.viridian.service.statement.persistence.StatementMain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.cayenne.Cayenne;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountsRegistered {

    private String id;

    private String accountCode;
    private String accountCurrency;
    private String accountType;
    private String customerCode;
    private String customerName;
    private String recipient;
    private Boolean enabled;
    private String formatAdapter;
    private String sendAdapter;
    private String corebankAdapter;
    private String frequency;
    private Boolean overwrittenByBank;
    private LocalDateTime timeCreate;
    private LocalDateTime timeModify;
    private String usrCreate;
    private String usrModify;


    public AccountsRegistered(StatementMain statementMain) {
        id = Cayenne.pkForObject(statementMain).toString();
        accountCode = statementMain.getAccountCode();
        accountCurrency = statementMain.getAccountCurrency();
        accountType = statementMain.getAccountType();
        customerCode = statementMain.getCustomerCode();
        customerName = statementMain.getCustomerName();
        recipient = statementMain.getSendRecipient();
        enabled = statementMain.isEnabled();
        formatAdapter = statementMain.getAdapterFormat();
        corebankAdapter = statementMain.getAdapterCorebank();
        sendAdapter = statementMain.getAdapterSend();
        frequency = statementMain.getFrequency();
        overwrittenByBank = statementMain.isOverwrittenByBank();
        timeCreate = statementMain.getTimeCreate();
        timeModify = statementMain.getTimeModify();
        usrCreate = statementMain.getUsrCreate();
        usrModify = statementMain.getUsrModify();
    }
}
