package cc.viridian.service.statement.service;

import cc.viridian.provider.CoreBankProvider;
import cc.viridian.provider.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.Random;

public class ScheduleService {
    private static final Logger log = LoggerFactory.getLogger(ScheduleService.class);

    private static ScheduleService instance = new ScheduleService();

    public static ScheduleService getInstance() {
        return instance;
    }

    private ScheduleService() {
    }

    public Statement getRandomStatement() {
        CoreBankProvider coreBank = CoreBankProvider.getInstance();
        Random random = new Random();

        String account =  (random.nextInt(99999) + 100000 ) + "00" + (random.nextInt(10) + 10);
        String type = "cc";
        String currency = "bob";
        LocalDate from = LocalDate.now().minusDays(7);
        LocalDate to = LocalDate.now().minusDays(1);
        Statement statement = coreBank.getStatement(account, type, currency, from, to );

        return statement;
    }
}
