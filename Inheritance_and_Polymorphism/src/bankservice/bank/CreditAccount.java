package bankservice.bank;

public class CreditAccount extends Account {
    private double limit;

    public CreditAccount(String id, String name, double balance, double limit) {
        super(id, name, balance);
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount >= -limit) {
            deposit(-amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %.2f, %.2f]", getId(), getName(), getBalance(), limit);
    }
}