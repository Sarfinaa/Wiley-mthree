class BankAccounts {
    protected int accNo;
    protected String accHoldername;
    protected int accBalance;

    BankAccounts(int accNo, String accHoldername, int accBalance) {
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

    public BankAccounts getStatement() {
        System.out.println("Name:" + getAccHoldername());
        System.out.println("Account Type:" + this.getClass().getSimpleName());
        return new BankAccounts(123, "Karan Seth", 100);
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

    public String toString() {
        return String.format("Account Number: %d %nAccount Holder Name: %s %nAccount Balance: %d", accNo,
                accHoldername, accBalance);
    }

    public void additionFeatures() {
    }

}

class SavingAccount extends BankAccounts {
    static final double rateOfInterest = 5;

    SavingAccount(int accNo, String accHoldername, int accBalance) {
        super(accNo, accHoldername, accBalance);

    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public SavingAccount getStatement() {
        System.out.println("Name:" + getAccHoldername());
        System.out.println("Account Type:" + this.getClass().getSimpleName());
        return new SavingAccount(124, "Karan Seth", 100);
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

class CurrentAccount extends BankAccounts {
    int avgDailyTransaction;

    public int getAvgDailyTransaction() {
        return avgDailyTransaction;
    }

    public void setAvgDailyTransaction(int avgDailyTransaction) {
        this.avgDailyTransaction = avgDailyTransaction;
    }

    public CurrentAccount getStatement() {
        System.out.println("Name:" + getAccHoldername());
        System.out.println("Account Type:" + this.getClass().getSimpleName());
        return new CurrentAccount(125, "Karan Seth", 100, 200);
    }

    CurrentAccount(int accNo, String accHoldername, int accBalance, int avgDailyTransaction) {
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

public class Bank {
    public static void main(String[] args) {
        BankAccounts generalAcc = new BankAccounts(233, "Karan Seth", 1000);
        SavingAccount savingAcc = new SavingAccount(234, "Karan Seth", 2000);
        CurrentAccount currentAcc = new CurrentAccount(235, "Karan Seth", 3000, 200);
        // BankAccounts salaryAcc = new BankAccounts(236, "Karan Seth", 1000) {
        // int salary = 10000;
        // int pfAmount = 2000;
        // float incomeTaxRate = 8;

        // float getYearlyTax() {
        // return (salary * 12) * incomeTaxRate / 100;
        // }

        // float getInHandSalary() {
        // float tax = salary * incomeTaxRate / 100;
        // return salary - tax - pfAmount;
        // }

        // @Override
        // public void additionFeatures() {
        // getYearlyTax();
        // getInHandSalary();
        // }

        // @Override
        // public String toString() {
        // return String.format(
        // "Salary: %d %nPf Amount: %d %nIncome Tax Rate: %.1f %nYearly Tax: %.1f %nGet
        // Inhand Salary: %.1f",
        // salary, pfAmount, incomeTaxRate, getYearlyTax(), getInHandSalary());
        // }

        // };
        String space = "--------------------------------";
        // System.out.println(generalAcc);
        // System.out.println(space);
        // System.out.println(savingAcc);
        // System.out.println("Yearly Interest: " + savingAcc.getYearlyInterest());
        // System.out.println("5 Years Interest: " + savingAcc.getComputedInterest(5));
        // System.out.println(space);
        // System.out.println(currentAcc);
        // System.out.println("Yearly Transaction: " +
        // currentAcc.getYearlyTransaction());
        // System.out.println("30 Day's Transaction: " +
        // currentAcc.getTotalTransactionAmount(30));
        // System.out.println(space);
        // System.out.println(salaryAcc);
        generalAcc.getStatement();
        savingAcc.getStatement();
        currentAcc.getStatement();
    }
}