package week_2;

abstract class BankAccounts1 {
    protected int accNo;
    protected String accHoldername;
    protected int accBalance;

    BankAccounts1(int accNo, String accHoldername, int accBalance) {
        this.accNo = accNo;
        this.accHoldername = accHoldername;
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

    abstract BankAccounts1 getStatement();

    public void setAccHoldername(String accHoldername) {
        this.accHoldername = accHoldername;
    }

    public int getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(int accBalance) {
        this.accBalance = accBalance;
    }

    public String toString() {
        return String.format("Account Number: %d %nAccount Holder Name: %s %nAccount Balance: %d", accNo,
                accHoldername, accBalance);
    }

}

class SavingAccounts1 extends BankAccounts1 {
    static final double rateOfInterest = 5;

    SavingAccounts1(int accNo, String accHoldername, int accBalance) {
        super(accNo, accHoldername, accBalance);

    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public SavingAccounts1 getStatement() {
        System.out.println("Name:" + getAccHoldername());
        System.out.println("Account Type:" + this.getClass().getSimpleName());
        return new SavingAccounts1(124, "Karan Seth", 100);
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

class CurrentAccounts1 extends BankAccounts1 {
    int avgDailyTransaction;

    public int getAvgDailyTransaction() {
        return avgDailyTransaction;
    }

    public void setAvgDailyTransaction(int avgDailyTransaction) {
        this.avgDailyTransaction = avgDailyTransaction;
    }

    public CurrentAccounts1 getStatement() {
        System.out.println("Name:" + getAccHoldername());
        System.out.println("Account Type:" + this.getClass().getSimpleName());
        return new CurrentAccounts1(125, "Karan Seth", 100, 200);
    }

    CurrentAccounts1(int accNo, String accHoldername, int accBalance, int avgDailyTransaction) {
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

public class GeneralAbstract {
    public static void main(String[] args) {
        SavingAccounts1 savingAcc = new SavingAccounts1(234, "Karan Seth", 2000);
        CurrentAccounts1 currentAcc = new CurrentAccounts1(235, "Karan Seth", 3000, 200);

        String space = "--------------------------------";
        savingAcc.getStatement();
        currentAcc.getStatement();
    }
}