package cc.viridian.service.statement.persistence.auto;

import java.time.LocalDateTime;

import cc.viridian.service.statement.persistence.Customer;
import cc.viridian.service.statement.persistence.Users;
import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _CustomerAccount was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _CustomerAccount extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final Property<String> ACCOUNT_CODE = Property.create("accountCode", String.class);
    public static final Property<LocalDateTime> CREATED_DATE = Property.create("createdDate", LocalDateTime.class);
    public static final Property<String> CURRENCY = Property.create("currency", String.class);
    public static final Property<LocalDateTime> DISABLED_DATE = Property.create("disabledDate", LocalDateTime.class);
    public static final Property<Boolean> ENABLED = Property.create("enabled", Boolean.class);
    public static final Property<String> NAME = Property.create("name", String.class);
    public static final Property<String> TYPE = Property.create("type", String.class);
    public static final Property<Users> X_CREATED_USER = Property.create("xCREATED_USER", Users.class);
    public static final Property<Customer> X_CUSTOMER = Property.create("xCUSTOMER", Customer.class);
    public static final Property<Users> X_DISABLED_USER = Property.create("xDISABLED_USER", Users.class);

    public void setAccountCode(String accountCode) {
        writeProperty("accountCode", accountCode);
    }
    public String getAccountCode() {
        return (String)readProperty("accountCode");
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        writeProperty("createdDate", createdDate);
    }
    public LocalDateTime getCreatedDate() {
        return (LocalDateTime)readProperty("createdDate");
    }

    public void setCurrency(String currency) {
        writeProperty("currency", currency);
    }
    public String getCurrency() {
        return (String)readProperty("currency");
    }

    public void setDisabledDate(LocalDateTime disabledDate) {
        writeProperty("disabledDate", disabledDate);
    }
    public LocalDateTime getDisabledDate() {
        return (LocalDateTime)readProperty("disabledDate");
    }

    public void setEnabled(boolean enabled) {
        writeProperty("enabled", enabled);
    }
	public boolean isEnabled() {
        Boolean value = (Boolean)readProperty("enabled");
        return (value != null) ? value.booleanValue() : false;
    }

    public void setName(String name) {
        writeProperty("name", name);
    }
    public String getName() {
        return (String)readProperty("name");
    }

    public void setType(String type) {
        writeProperty("type", type);
    }
    public String getType() {
        return (String)readProperty("type");
    }

    public void setXCREATED_USER(Users xCREATED_USER) {
        setToOneTarget("xCREATED_USER", xCREATED_USER, true);
    }

    public Users getXCREATED_USER() {
        return (Users)readProperty("xCREATED_USER");
    }


    public void setXCUSTOMER(Customer xCUSTOMER) {
        setToOneTarget("xCUSTOMER", xCUSTOMER, true);
    }

    public Customer getXCUSTOMER() {
        return (Customer)readProperty("xCUSTOMER");
    }


    public void setXDISABLED_USER(Users xDISABLED_USER) {
        setToOneTarget("xDISABLED_USER", xDISABLED_USER, true);
    }

    public Users getXDISABLED_USER() {
        return (Users)readProperty("xDISABLED_USER");
    }


}