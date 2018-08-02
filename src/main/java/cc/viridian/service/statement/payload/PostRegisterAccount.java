package cc.viridian.service.statement.payload;

public class PostRegisterAccount {

    private String account;
    private String currency;
    private String type;
    private String frequency;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PostRegisterAccount() {

    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public PostRegisterAccount(String account, String currency, String type, String frequency) {
        this.account = account;
        this.currency = currency;
        this.type = type;
        this.frequency = frequency;
    }
}
