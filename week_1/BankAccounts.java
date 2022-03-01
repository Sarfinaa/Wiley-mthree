package week_1;

class Account {
    protected int amount;
    protected String accountHolder;

    protected static void debitAmount(Account acc, int amount) {
        if (amount > acc.amount)
            System.out.println("Insufficient Balance");
        else {
            acc.amount -= amount;
            System.out
                    .println(amount + " debited from " + acc.accountHolder + "\n" + "Remaining Balance: " + acc.amount);
        }
    }

    protected static void creditAmount(Account acc, int amount) {
        acc.amount += amount;
        System.out.println(amount + " credited to " + acc.accountHolder + "\n" + "Updated Balance: " + acc.amount);
    }

    Account(int amount, String accountHolder) {
        this.amount = amount;
        this.accountHolder = accountHolder;
    }
}

public class BankAccounts {
    public static void main(String[] args) {
        Account acc1 = new Account(10000, "Karan Seth");
        Account acc2 = new Account(1000, "Shivam Khanna");
        System.out.println("Name: " + acc1.accountHolder + "\nAccount: " + acc1.amount);
        System.out.println("Name: " + acc2.accountHolder + "\nAccount: " + acc2.amount);
        System.err.println("----------------------------------------------------------------");
        Account.debitAmount(acc1, 9000);
        System.err.println("----------------------------------------------------------------");
        Account.creditAmount(acc1, 10000);
    }
}
