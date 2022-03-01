import java.util.*;

class BankAccount {
    protected int accNo;
    protected String accHoldername;
    protected int accBalance;

    BankAccount() {
    }

    BankAccount(int accNo, String accHoldername) {
        this.accNo = accNo;
        this.accHoldername = accHoldername;
    }

    BankAccount(int accNo, String accHoldername, int accBalance) {
        this(accNo, accHoldername);
        this.accBalance = accBalance;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getAccHoldername() {
        return accHoldername;
    }

    public void setAccHoldername(String accHoldername) {
        this.accHoldername = accHoldername;
    }

    public int getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(int accBalance) {
        this.accBalance = accBalance;
    }

    public static BankAccount copyAcc(BankAccount acc) {
        return new BankAccount(acc.accNo, acc.accHoldername);

    }

    public String toString() {
        return String.format("Account Number: %d %nAccount Holder Name: %s %nAccount Balance: %d", accNo,
                accHoldername, accBalance);
    }

    public void additionFeatures() {
    }

}

class SavingAccounts extends BankAccount {
    static final double rateOfInterest = 5;

    SavingAccounts() {
    }

    SavingAccounts(int accNo, String accHoldername) {
        super(accNo, accHoldername);
    }

    SavingAccounts(int accNo, String accHoldername, int accBalance) {
        super(accNo, accHoldername, accBalance);

    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public double getComputedInterest(int years) {
        return rateOfInterest * getAccBalance() * years / 100;
    }

    public double getYearlyInterest() {
        return getComputedInterest(1);
    }

    @Override
    public String toString() {

        return super.toString() + "\nRate of Interest: " + rateOfInterest;
    }
}

class CurrentAccounts extends BankAccount {
    int avgDailyTransaction;

    public int getAvgDailyTransaction() {
        return avgDailyTransaction;
    }

    public void setAvgDailyTransaction(int avgDailyTransaction) {
        this.avgDailyTransaction = avgDailyTransaction;
    }

    CurrentAccounts(int accNo, String accHoldername, int accBalance, int avgDailyTransaction) {
        super(accNo, accHoldername, accBalance);
        this.avgDailyTransaction = avgDailyTransaction;
    }

    public int getTotalTransactionAmount(int days) {
        return avgDailyTransaction * days;

    }

    public int getYearlyTransaction() {
        return getTotalTransactionAmount(365);
    }

    @Override
    public String toString() {

        return super.toString() + "\nAverage Daily Transaction Amount: " + avgDailyTransaction;
    }

}

public class Bank1 {
    public static void main(String[] args) {
        System.out.print("Enter the value of n: ");
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        BankAccount[] bankAccounts = new BankAccount[n];
        SavingAccounts[] savingAccounts = new SavingAccounts[n];
        CurrentAccounts[] currentAccounts = new CurrentAccounts[n];
        BankAccount[] bankAccount = new BankAccount[n];
        int generalAccNo = 100;
        int savingAccNo = 200;
        int currentAccNo = 300;
        for (int i = 0; i < n; i++) {
            System.out.print("Name: ");
            String name = s.nextLine();
            System.out.print("Amount: ");
            int amount = Integer.parseInt(s.next());
            bankAccounts[i] = new BankAccount(i + generalAccNo, name, amount);
            savingAccounts[i] = new SavingAccounts(i + savingAccNo, name, amount);
            currentAccounts[i] = new CurrentAccounts(i + currentAccNo, name, amount, 200);
            bankAccount[i] = new BankAccount(236, "Karan Seth", 1000) {
                int salary = 10000;
                int pfAmount = 2000;
                float incomeTaxRate = 8;

                float getYearlyTax() {
                    return (salary * 12) * incomeTaxRate / 100;
                }

                float getInHandSalary() {
                    float tax = salary * incomeTaxRate / 100;
                    return salary - tax - pfAmount;
                }

                @Override
                public void additionFeatures() {
                    getYearlyTax();
                    getInHandSalary();
                }

                @Override
                public String toString() {
                    return String.format(
                            "Salary: %d %nPf Amount: %d %nIncome Tax Rate: %.1f %nYearly Tax: %.1f %nGet Inhand Salary: %.1f",
                            salary, pfAmount, incomeTaxRate, getYearlyTax(), getInHandSalary());
                }
            };
        }
        String space = "--------------------------------";
        System.out.println(space);
        for (BankAccount acc : bankAccounts)
            System.out.println(acc);
        System.out.println(space);
        for (SavingAccounts acc : savingAccounts)
            System.out.println(acc);
        System.out.println(space);
        for (CurrentAccounts acc : currentAccounts)
            System.out.println(acc);
        System.out.println(space);
        System.out.println("    !!!Copied Bank Accounts!!!");
        System.out.println(BankAccount.copyAcc(currentAccounts[0]));
        System.out.println(space);

    }
}