package cc.viridian.service.statement.persistence.auto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import cc.viridian.service.statement.persistence.Account;
import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _Transaction was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Transaction extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final Property<BigDecimal> AMOUNT = Property.create("amount", BigDecimal.class);
    public static final Property<String> CURRENCY = Property.create("currency", String.class);
    public static final Property<LocalDateTime> DATE = Property.create("date", LocalDateTime.class);
    public static final Property<String> DESCRIPTION = Property.create("description", String.class);
    public static final Property<String> SOURCE = Property.create("source", String.class);
    public static final Property<String> TARGET = Property.create("target", String.class);
    public static final Property<String> TYPE = Property.create("type", String.class);
    public static final Property<Account> X_SOURCE = Property.create("xSOURCE", Account.class);
    public static final Property<Account> X_TARGET = Property.create("xTARGET", Account.class);

    public void setAmount(BigDecimal amount) {
        writeProperty("amount", amount);
    }
    public BigDecimal getAmount() {
        return (BigDecimal)readProperty("amount");
    }

    public void setCurrency(String currency) {
        writeProperty("currency", currency);
    }
    public String getCurrency() {
        return (String)readProperty("currency");
    }

    public void setDate(LocalDateTime date) {
        writeProperty("date", date);
    }
    public LocalDateTime getDate() {
        return (LocalDateTime)readProperty("date");
    }

    public void setDescription(String description) {
        writeProperty("description", description);
    }
    public String getDescription() {
        return (String)readProperty("description");
    }

    public void setSource(String source) {
        writeProperty("source", source);
    }
    public String getSource() {
        return (String)readProperty("source");
    }

    public void setTarget(String target) {
        writeProperty("target", target);
    }
    public String getTarget() {
        return (String)readProperty("target");
    }

    public void setType(String type) {
        writeProperty("type", type);
    }
    public String getType() {
        return (String)readProperty("type");
    }

    public void setXSOURCE(Account xSOURCE) {
        setToOneTarget("xSOURCE", xSOURCE, true);
    }

    public Account getXSOURCE() {
        return (Account)readProperty("xSOURCE");
    }


    public void setXTARGET(Account xTARGET) {
        setToOneTarget("xTARGET", xTARGET, true);
    }

    public Account getXTARGET() {
        return (Account)readProperty("xTARGET");
    }


}