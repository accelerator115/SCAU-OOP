package bankservice;

import bankservice.bank.*;

public class Main {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();

        manager.addAccount(new CreditAccount("C001", "Alan", 0, 1000));
        manager.addAccount(new CreditAccount("C002", "Bob", 1000, 2000));
        manager.addAccount(new CreditAccount("C003", "Cat", 2000, 1000));
        manager.addAccount(new SavingAccount("S001", "张三"));
        manager.addAccount(new SavingAccount("S002", "李四", 500));
        manager.addAccount(new SavingAccount("S003", "王五", 2000));
        manager.addAccount(new SavingAccount("S004", "刘六", 100));

        showAccounts(manager.getAllAccounts());
        System.out.printf("共%d个账户，其信用卡账户%d个，合计余额: %.2f元.\n\n", manager.getSize(), manager.getNumberOfCreditAccount(),
                manager.getTotalBalance());

        Account account = manager.getAccount("C003");
        System.out.println("取款前：" + account);
        if (account.withdraw(2000)) {
            System.out.println("取款[2000.00]后，" + account);
        } else {
            System.out.println("取款[2000.00]余额不足.");
        }
        account.deposit(1500);
        System.out.println("存入[1500.00]后，" + account);

        if (manager.removeAccount("S001")) {
            System.out.println("账号为[S001]的账户删除成功.");
        } else {
            System.out.println("账号为[S001]的账户删除失败.");
        }
        showAccounts(manager.getAllAccounts());
        System.out.printf("共%d个账户，其信用卡账户%d个，合计余额: %.2f元.\n\n", manager.getSize(), manager.getNumberOfCreditAccount(),
                manager.getTotalBalance());
    }

    public static void showAccounts(Account[] list) {
        System.out.println("所有账户: ");
        for (Account account : list) {
            System.out.println(account);
        }
        System.out.println("-".repeat(50));
    }
}