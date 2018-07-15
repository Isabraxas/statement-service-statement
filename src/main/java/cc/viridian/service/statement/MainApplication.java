package cc.viridian.service.statement;

import cc.viridian.provider.CoreBankProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);

        CoreBankProvider coreBank = CoreBankProvider.getInstance();
        System.out.println(MainApplication.lookup(coreBank, "00001"));
        System.out.println(MainApplication.lookup(coreBank, "00002"));

        System.out.println(coreBank.getStatement("333333","cc", "bob", new Date(), new Date() ));
    }


    public static String lookup(CoreBankProvider coreBankProvider, String word) {
        String outputString = word + ": ";
        String definition = coreBankProvider.getStatement( word, "cc", "bob", new Date(), new Date() ).toString();
        if (definition == null) {
            return outputString + "Cannot find CoreBankProvider for this word.";
        } else {
            return outputString + definition;
        }
    }

}
