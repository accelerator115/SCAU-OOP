package bankservice.bank;

import java.util.Arrays;

public class AccountManager {
    private Account[] accountList;
    private int size;

    public AccountManager() {
        this.accountList = new Account[10];
        this.size = 0;
    }

    public boolean addAccount(Account account) {
        for (int i = 0; i < size; i++) {
            if (accountList[i].getId().equals(account.getId())) {
                return false;
            }
        }

        if (size == accountList.length) {
            accountList = Arrays.copyOf(accountList, accountList.length * 2);
        }

        accountList[size++] = account;
        return true;
    }

    public boolean removeAccount(String id) {
        for (int i = 0; i < size; i++) {
            if (accountList[i].getId().equals(id)) {
                if (accountList[i].getBalance() == 0) {
                    System.arraycopy(accountList, i + 1, accountList, i, size - i - 1);
                    accountList[--size] = null;
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public Account getAccount(String id) {
        for (int i = 0; i < size; i++) {
            if (accountList[i].getId().equals(id)) {
                return accountList[i];
            }
        }
        return null;
    }

    public double getTotalBalance() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += accountList[i].getBalance();
        }
        return total;
    }

    public int getNumberOfCreditAccount() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (accountList[i] instanceof CreditAccount) {
                count++;
            }
        }
        return count;
    }

    public int getSize() {
        return size;
    }

    public Account[] getAllAccounts() {
        return Arrays.copyOf(accountList, size);
    }
}