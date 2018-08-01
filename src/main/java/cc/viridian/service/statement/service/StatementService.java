package cc.viridian.service.statement.service;

import cc.viridian.service.statement.payload.AccountsRegistered;
import cc.viridian.service.statement.payload.ListAccountsResponse;
import cc.viridian.service.statement.payload.PostRegisterAccount;
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
import java.util.*;

@Component
public class StatementService {
    private static final Logger log = LoggerFactory.getLogger(StatementService.class);

    @Autowired
    ServerRuntime mainServerRuntime;

    public String registerNewAccount(PostRegisterAccount body) {
        String accountCurrency = body.getCurrency();
        String accountNumber = body.getAccount();
        String accountType = body.getType();

        ObjectContext context = mainServerRuntime.newContext();
        StatementMain statementMain = context.newObject(StatementMain.class);

        statementMain.setAccountCode(accountNumber);
        statementMain.setAccountCurrency(accountCurrency);
        statementMain.setAccountType(accountType);
        statementMain.setCustomerCode(accountNumber.substring(0,6));
        statementMain.setCustomerName("name");
        statementMain.setEnabled(true);
        statementMain.setFrequency("DAILY");
        statementMain.setOverwrittenByBank(false);
        statementMain.setTimeCreate(LocalDateTime.now());
        statementMain.setTimeModify(LocalDateTime.now());
        statementMain.setUsrCreate("user1");
        statementMain.setUsrModify("user1");

        context.commitChanges();
        return accountNumber;
    }


    public ListAccountsResponse listAccounts(Integer start, Integer length)
    {
        ObjectContext context = mainServerRuntime.newContext();

        //Select all statement
        List<StatementMain> accounts = ObjectSelect.query(StatementMain.class)
            .limit(length)
            .offset(start)
            .select(context);

        List<AccountsRegistered> accountsRegistered = new ArrayList<>();

        Iterator<StatementMain> it = accounts.iterator();
        while (it.hasNext()) {
            accountsRegistered.add(new AccountsRegistered(it.next()) );
        }


        ListAccountsResponse response = new ListAccountsResponse();
        response.setData(accountsRegistered);

        response.setRecordsFiltered( countAllAccounts() );
        response.setRecordsTotal(countAllAccounts());

        return response;
    }

    public Long countAllAccounts ()
    {
        ObjectContext context = mainServerRuntime.newContext();

        //Select count(*) from statement_main
        EJBQLQuery query = new EJBQLQuery("select count(s) from StatementMain s");
        List<Long> result = context.performQuery(query);

        return result.get(0);
    }

}
