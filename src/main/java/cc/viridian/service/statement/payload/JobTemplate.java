package cc.viridian.service.statement.payload;

import cc.viridian.service.statement.persistence.StatementJob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class JobTemplate {
    private String account;
    private String currency;
    private String type;
    private String frequency;
    private String customerCode;
    private String recipient;
    private String formatAdapter;
    private String sendAdapter;
    private String coreBankAdapter;

    public JobTemplate(StatementJob job) {
        this.account = job.getAccountCode();
        this.currency = job.getAccountCurrency();
        this.type = job.getAccountType();
        this.frequency = job.getFrequency();
        this.customerCode = job.getCustomerCode();
        this.recipient = job.getSendRecipient();
        this.formatAdapter = job.getAdapterFormat();
        this.sendAdapter = job.getAdapterSend();
        this.coreBankAdapter = job.getAdapterCorebank();
    }
}
