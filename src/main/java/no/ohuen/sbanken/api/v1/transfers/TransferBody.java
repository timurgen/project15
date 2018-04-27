
package no.ohuen.sbanken.api.v1.transfers;

/**
 *
 * @author Timur Samkharadze
 */
public class TransferBody {
    private final String fromAccount;
    private final String toAccount;
    private final double ammount;
    private final String message;

    public TransferBody(String fromAccount, String toAccount, double ammount, String message) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.ammount = ammount;
        this.message = message;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public double getAmmount() {
        return ammount;
    }

    public String getMessage() {
        return message;
    }
    
    
    
}
