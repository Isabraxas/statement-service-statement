package cc.viridian.service.statement.service;

import cc.viridian.service.statement.persistence.Account;
import cc.viridian.service.statement.persistence.Transaction;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
public class AccountService {
    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    ServerRuntime mainServerRuntime;

    private String[] lastnames = {
        "GARCÍA", "GONZÁLEZ", "RODRÍGUEZ", "FERNÁNDEZ",
        "LÓPEZ", "MARTÍNEZ", "SÁNCHEZ", "PÉREZ",
        "GÓMEZ", "MARTIN", "JIMÉNEZ", "RUIZ",
        "HERNÁNDEZ", "DIAZ", "MORENO", "MUÑOZ", "ÁLVAREZ",
        "ROMERO", "ALONSO", "GUTIÉRREZ", "NAVARRO", "TORRES",
        "DOMÍNGUEZ", "VÁZQUEZ", "RAMOS", "GIL", "RAMÍREZ", "SERRANO",
        "BLANCO", "MOLINA", "MORALES", "SUAREZ", "ORTEGA", "DELGADO",
        "CASTRO", "ORTIZ", "RUBIO", "MARÍN", "SANZ", "NÚÑEZ", "IGLESIAS",
        "MEDINA", "GARRIDO", "CORTES", "CASTILLO", "SANTOS", "LOZANO",
        "GUERRERO", "CANO", "PRIETO", "MÉNDEZ", "CRUZ", "CALVO", "GALLEGO",
        "VIDAL", "LEÓN", "MÁRQUEZ", "HERRERA", "PEÑA", "FLORES", "CABRERA",
        "CAMPOS", "VEGA", "FUENTES", "CARRASCO", "DIEZ", "CABALLERO",
        "REYES", "NIETO", "AGUILAR", "PASCUAL", "SANTANA", "HERRERO", "LORENZO",
        "MONTERO", "HIDALGO", "GIMÉNEZ", "IBÁÑEZ", "FERRER", "DURAN",
        "SANTIAGO", "BENÍTEZ", "MORA", "VICENTE", "VARGAS", "ARIAS",
        "CARMONA", "CRESPO", "ROMÁN", "PASTOR", "SOTO", "SÁEZ",
        "VELASCO", "MOYA", "SOLER", "PARRA", "ESTEBAN", "BRAVO", "GALLARDO", "ROJAS"
    };

    private String[] names = {
        "MARIA CARMEN",        "MARIA", "CARMEN",        "JOSEFA",
        "ISABEL",        "ANA MARIA", "MARIA PILAR",        "MARIA DOLORES",
        "MARIA TERESA",        "ANA",        "LAURA",        "FRANCISCA",
        "MARIA ANGELES",        "CRISTINA",        "ANTONIA",        "MARTA",
        "DOLORES",        "MARIA ISABEL",        "MARIA JOSE",        "LUCIA",
        "MARIA LUISA",        "PILAR",        "ELENA",        "CONCEPCION",
        "SARA",        "PAULA",        "MANUELA",        "MERCEDES",
        "ROSA MARIA",        "RAQUEL",        "MARIA JESUS",        "JUANA",
        "ROSARIO",        "TERESA",        "ENCARNACION",        "BEATRIZ",
        "NURIA",        "SILVIA",        "JULIA",        "ROSA",
        "MONTSERRAT",        "PATRICIA",        "IRENE",        "ANDREA",
        "ROCIO",        "MONICA",        "ALBA",        "MARIA MAR",
        "ANGELA",        "SONIA",        "ALICIA",        "SANDRA",
        "SUSANA",        "MARGARITA",        "MARINA",        "YOLANDA",
        "MARIA JOSEFA",        "NATALIA",        "MARIA ROSARIO",        "INMACULADA",
        "EVA",        "MARIA MERCEDES",        "ESTHER",        "ANA ISABEL",
        "ANGELES",        "NOELIA",        "CLAUDIA",        "VERONICA",
        "AMPARO",        "MARIA ROSA",        "CAROLINA",        "MARIA VICTORIA",
        "CARLA",        "EVA MARIA",        "MARIA CONCEPCION",        "NEREA",
        "LORENA",        "ANA BELEN",        "VICTORIA",        "MIRIAM",
        "MARIA ELENA",        "SOFIA",        "CATALINA",        "INES",
        "MARIA ANTONIA",        "CONSUELO",        "EMILIA",        "MARIA NIEVES",
        "LIDIA",        "LUISA",        "GLORIA",        "CELIA",
        "OLGA",        "AURORA",        "ESPERANZA",        "JOSEFINA",
        "MARIA SOLEDAD",        "MILAGROS",        "MARIA CRISTINA",        "DANIELA",
        "ANTONIO","JOSE","MANUEL","FRANCISCO","JUAN","DAVID",
        "JOSE ANTONIO","JOSE LUIS","JAVIER","FRANCISCO JAVIER",
        "JESUS","DANIEL","CARLOS","MIGUEL","ALEJANDRO","JOSE MANUEL",
        "RAFAEL","PEDRO","ANGEL","MIGUEL ANGEL",
        "JOSE MARIA","FERNANDO","PABLO","LUIS",
        "SERGIO","JORGE","ALBERTO","JUAN CARLOS","JUAN JOSE",
        "ALVARO","DIEGO","ADRIAN","JUAN ANTONIO","RAUL",
        "ENRIQUE","RAMON","VICENTE","IVAN","RUBEN","OSCAR",
        "ANDRES","JOAQUIN","JUAN MANUEL","SANTIAGO","EDUARDO",
        "VICTOR","ROBERTO","JAIME","FRANCISCO JOSE",
        "MARIO","IGNACIO","ALFONSO","SALVADOR",
        "RICARDO","MARCOS","JORDI","EMILIO",
        "JULIAN","JULIO","GUILLERMO","GABRIEL",
        "TOMAS","AGUSTIN","JOSE MIGUEL","MARC",
        "GONZALO","FELIX","JOSE RAMON","MOHAMED",
        "HUGO","JOAN","ISMAEL","NICOLAS",
        "CRISTIAN","SAMUEL","MARIANO","JOSEP",
        "DOMINGO","JUAN FRANCISCO","AITOR","MARTIN","ALFREDO","SEBASTIAN",
        "JOSE CARLOS","FELIPE","HECTOR","CESAR","JOSE ANGEL","JOSE IGNACIO",
        "VICTOR MANUEL","IKER","GREGORIO","LUIS MIGUEL","ALEX","JOSE FRANCISCO",
        "JUAN LUIS","RODRIGO","ALBERT","XAVIER","LORENZO"

    };

    public String addCheckDigit(String number)
    {
        int Sum = 0;
        for (int i = number.length() - 1, Multiplier = 2; i >= 0; i--)
        {
            Sum += (int)number.charAt(i) * Multiplier;

            if (++Multiplier == 8) Multiplier = 2;
        }
        String Validator = "" + (11 - (Sum % 11));

        if (Validator == "11") {
            Validator = "0";
        } else {
            if (Validator == "10") {
                Validator = "X";
            }
        }

        return number + Validator;
    }

    private void newAccount(ObjectContext context) {
        Random random = new Random();
        String currency = random.nextInt(100) < 70 ? "1" : "2";
        String accountNumber = "" + (random.nextInt(800000) + 100000) + "0" + currency;
        accountNumber = addCheckDigit(accountNumber);

        Account account = context.newObject(Account.class);
        account.setNumber( accountNumber);
        if (currency.equals("1")) {
            account.setCurrency("BOB");
        } else {
            account.setCurrency("USD");
        }
        account.setBalance(new BigDecimal(random.nextInt(2000) * 5) );

        account.setFirstname( names[random.nextInt(names.length) ] );
        account.setLastname( lastnames[random.nextInt(lastnames.length) ] );
        account.setCreateDate(LocalDateTime.now());
        context.commitChanges();
    }

    public Integer createAccounts(Integer quantity) {
        ObjectContext context = mainServerRuntime.newContext();

        for (int i=0; i<quantity; i++) {
            newAccount(context);
        }
        return quantity;
    }

    private Account getRandomAccountWithBalance(ObjectContext context, int totalAccounts) throws Exception {
        Random random = new Random();
        int times = 0;
        do {
            List<Account> accounts = ObjectSelect.query(Account.class).limit(1).offset(
                random.nextInt(totalAccounts)).select(context);

            if (accounts.size() > 0) {
                if (accounts.get(0).getBalance().doubleValue() > 0) {
                    return accounts.get(0);
                }
            }
            times ++;
        } while (times < 100);

        throw (new Exception("statement in database are not present or they have 0 in their balance."));
    }

    public void newTransaction(ObjectContext context) {
        Random random = new Random();
        try {
            int totalAccounts = new Long(ObjectSelect.query(Account.class).selectCount(context)).intValue();
            Account source = getRandomAccountWithBalance(context, totalAccounts);
            Account target = getRandomAccountWithBalance(context, totalAccounts);

            int amount = random.nextInt(source.getBalance().intValue()/5 )*5;
            Transaction transaction = context.newObject(Transaction.class);
            transaction.setAmount( new BigDecimal(amount));
            transaction.setDate(LocalDateTime.now());
            transaction.setDescription( source.getFirstname() + " sends " + amount + " " + source.getCurrency() +
                                            " to " + target.getFirstname());
            transaction.setType("C");
            transaction.setXSOURCE(source);
            transaction.setXTARGET(target);
            transaction.setSource(source.getNumber());
            transaction.setTarget(target.getNumber());
            transaction.setCurrency(source.getCurrency());
            context.commitChanges();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //public  List<Account> listAccounts(Integer page)
    public  String listAccounts(Integer page)
    {
        ObjectContext context = mainServerRuntime.newContext();

        //Select all statement
        List<Account> accounts = ObjectSelect.query(
            Account.class)
                                             .limit(100)
                                             .offset((page -1)*100)
                                             .select(context);

        StringBuilder sb = new StringBuilder();
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext()) {
            Account a = it.next();
            Map<String, Object> idMap = a.getObjectId().getIdSnapshot();

            sb.append( idMap.get("ID") +
                                    " " + a.getNumber() +
                                    " " + a.getFirstname() +
                                    " " + a.getLastname() +
                                    " " + a.getCurrency() + " " + a.getBalance() +
            "\n");
        }

        return sb.toString();
    }

    public  String getAccountByNumber(String number)
    {
        ObjectContext context = mainServerRuntime.newContext();

        //Select this account
        List<Account> accounts = ObjectSelect.query(
            Account.class)
                                      .where(Account.NUMBER.eq(number))
                                             .limit(1)
                                             .select(context);

        StringBuilder sb = new StringBuilder();
        Iterator<Account> it = accounts.iterator();
        while (it.hasNext()) {
            Account a = it.next();
            Map<String, Object> idMap = a.getObjectId().getIdSnapshot();

            sb.append( idMap.get("ID") +
                           " " + a.getNumber() +
                           " " + a.getFirstname() +
                           " " + a.getLastname() +
                           " " + a.getCurrency() + " " + a.getBalance() +
                           "\n");
        }

        List<Transaction> debits = ObjectSelect.query(
            Transaction.class)
                                             .where(Transaction.SOURCE.eq(number))
                                             .select(context);
        Iterator<Transaction> itt = debits.iterator();
        while (itt.hasNext()) {
            Transaction t = itt.next();
            Map<String, Object> idMap = t.getObjectId().getIdSnapshot();

            sb.append( idMap.get("ID") +
                           " " + t.getDate() +
                           " DEBIT  " +
                           " " + t.getCurrency() +
                           " " + t.getAmount() +
                           " " + t.getSource() +
                           " " + t.getTarget() +
                           " " + t.getDescription() +
                           "\n");
        }

        List<Transaction> credits = ObjectSelect.query(
            Transaction.class)
                                               .where(Transaction.TARGET.eq(number))
                                               .select(context);
        itt = credits.iterator();
        while (itt.hasNext()) {
            Transaction t = itt.next();
            Map<String, Object> idMap = t.getObjectId().getIdSnapshot();

            sb.append( idMap.get("ID") +
                           " " + t.getDate() +
                           " CREDIT " +
                           " " + t.getCurrency() +
                           " " + t.getAmount() +
                           " " + t.getSource() +
                           " " + t.getTarget() +
                           " " + t.getDescription() +
                           "\n");
        }
        return sb.toString();
    }

    public Integer createTransactions(Integer quantity) {
        ObjectContext context = mainServerRuntime.newContext();

        for (int i=0; i<quantity; i++) {
            newTransaction(context);
        }
        return quantity;
    }

    private String headerAbnAmro() {
        return "ABNANL2A\n" +
            "940\n" +
            "ABNANL2A\n";
    }

    private String trailerAbnAmro() {
        return "-\n";
    }

    //16x     Account number
    private String transactionReferenceNumber(String accountNumber) {
        return ":20:" + accountNumber + "\n";
    }

    private String accountNumber(String accountNumber) {
        return ":25:" + accountNumber + "\n";
    }

    private String statementNumber() {
        String todayNumber = "0000" + LocalDate.now().getDayOfYear() + "01";
        return ":28:" + todayNumber.substring( todayNumber.length()-7, todayNumber.length()) + "/01\n";
    }

    private String openingBalance(LocalDateTime date, String currency, BigDecimal amount) {
        String credit = "C";
        String statementDate = date.format(DateTimeFormatter.ofPattern("yyMMdd"));

        return ":60F:" + credit + statementDate + currency + amount.toString() + "\n";
    }

    private String closingBalance(LocalDateTime date, String currency, BigDecimal amount) {
        String credit = "C";
        String statementDate = date.format(DateTimeFormatter.ofPattern("yyMMdd"));

        return ":62F:" + credit + statementDate + currency + amount.toString() + "\n";
    }

    private String closingAvailableBalance(LocalDateTime date, String currency, BigDecimal amount) {
        String credit = "C";
        String statementDate = date.format(DateTimeFormatter.ofPattern("yyMMdd"));

        return ":64:" + credit + statementDate + currency + amount.toString() + "\n";
    }

    private String statementLine(LocalDateTime date, String credit, BigDecimal amount, String txType, String txNumber) {
        String valueDate = date.format(DateTimeFormatter.ofPattern("yyMMdd"));
        String transactionDate = date.format(DateTimeFormatter.ofPattern("MMdd"));

        return ":61:" + valueDate + transactionDate + credit + amount.toString() + txType + txNumber + "\n";
    }

    private String infoAccountOwner(String field1, String field2, String field3, String field4, String field5, String field6) {
        return ":85:" + "/" + field1 + "/" + field2  + "/" + field3 + "/" + field4  + "/" + field5 +"/" + field6 + "\n";
    }

    public String createMta(String number) {

        ObjectContext context = mainServerRuntime.newContext();

        //Select this account
        List<Account> accounts = ObjectSelect.query(
            Account.class)
                                             .where(Account.NUMBER.eq(number))
                                             .limit(1)
                                             .select(context);
        if (accounts.size() != 1) {
            return "";
        }

        Account account = accounts.get(0);

        StringBuilder sb = new StringBuilder();
        sb.append(headerAbnAmro());

        sb.append(transactionReferenceNumber("" + account.getNumber()));
        sb.append(accountNumber("" + account.getNumber()));
        sb.append(statementNumber());

        sb.append(openingBalance(LocalDateTime.now(), account.getCurrency(), account.getBalance()));

        List<Transaction> credits = ObjectSelect.query(
            Transaction.class)
                                                .where(Transaction.TARGET.eq(number))
                                                .select(context);
        Iterator<Transaction>itt = credits.iterator();
        while (itt.hasNext()) {
            Transaction t = itt.next();
            Map<String, Object> idMap = t.getObjectId().getIdSnapshot();

            sb.append(statementLine(
               t.getDate(),
               "C",
               t.getAmount(),
               "NTRF",
               idMap.get("ID").toString()
            ));


            Map<String, Object> idMapSource = t.getXSOURCE().getObjectId().getIdSnapshot();
            Map<String, Object> idMapTarget = t.getXTARGET().getObjectId().getIdSnapshot();
            sb.append( infoAccountOwner(
                "TRANSFER",
                idMapSource.get("ID").toString(),
                t.getXSOURCE().getFirstname() + " " + t.getXSOURCE().getLastname(),
                t.getSource(),
                account.getCurrency(),
                t.getDescription()
            ));
        }

        List<Transaction> debits = ObjectSelect.query(
            Transaction.class)
                                               .where(Transaction.SOURCE.eq(number))
                                               .select(context);
        itt = debits.iterator();
        while (itt.hasNext()) {
            Transaction t = itt.next();
            Map<String, Object> idMap = t.getObjectId().getIdSnapshot();

            sb.append(statementLine(
                t.getDate(),
                "D",
                t.getAmount(),
                "NTRF",
                idMap.get("ID").toString()
            ));


            Map<String, Object> idMapSource = t.getXSOURCE().getObjectId().getIdSnapshot();
            Map<String, Object> idMapTarget = t.getXTARGET().getObjectId().getIdSnapshot();
            sb.append( infoAccountOwner(
                "TRANSFER",
                idMapTarget.get("ID").toString(),
                t.getXTARGET().getFirstname() + " " + t.getXTARGET().getLastname(),
                t.getTarget(),
                account.getCurrency(),
                t.getDescription()
            ));
        }

        sb.append(closingBalance(LocalDateTime.now(), account.getCurrency(), account.getBalance()));
        sb.append(closingAvailableBalance(LocalDateTime.now(), account.getCurrency(), account.getBalance()));

        sb.append(trailerAbnAmro());
        return sb.toString();

    }
}
