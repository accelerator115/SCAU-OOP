package bankservice.bank;

public class SavingAccount extends Account {
    public SavingAccount(String id, String name) {
        super(id, name, 0);
    }

    public SavingAccount(String id, String name, double balance) {
        super(id, name, balance);
    }
}