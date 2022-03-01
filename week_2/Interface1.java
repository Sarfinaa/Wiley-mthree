package week_2;

interface WorldBank {

    void showBalance();

    double withdraw(double amount);

    double deposit(double amount);
}

interface RBI extends WorldBank {
    double RATE_OF_INTEREST = 4;

    double calculateYearlyInterest();
}

class Accounts implements RBI {
    protected int accNo;
    protected String accHoldername;
    protected int accBalance;

    Accounts(int accNo, String accHoldername, int accBalance) {
        this.accNo = accNo;
        this.accHoldername = accHoldername;
        this.accBalance = accBalance;
    }

    public void showBalance() {
        System.out.println("Balance: " + accBalance);
    }

    public double withdraw(double amount) {
        if (accBalance < amount) {
            System.out.println("No Money in account");
            return 0;
        }
        accBalance -= amount;
        return amount;
    }

    public double deposit(double amount) {
        accBalance += amount;
        return amount;
    }

    public double calculateYearlyInterest() {
        return accBalance * 1 * RATE_OF_INTEREST / 100;
    }

    @Override
    public String toString() {
        return "Accounts [accBalance=" + accBalance + ", accHoldername=" + accHoldername + ", accNo=" + accNo + "]";
    }

}

class SBIAccount extends Accounts {
    static int ACC_OPENING_BONUS = 1000;

    SBIAccount(int accNo, String accHoldername, int accBalance) {
        super(accNo, accHoldername, accBalance);
        this.accBalance += ACC_OPENING_BONUS;
    }

    void displayFeatures() {
        System.out.println("Additional " + ACC_OPENING_BONUS + " credited to a new account in SBI");
    }

}

class ICICIAccount extends Accounts {
    static double ADDITONAL_INTEREST_RATE = 2;

    ICICIAccount(int accNo, String accHoldername, int accBalance) {
        super(accNo, accHoldername, accBalance);
    }

    @Override
    public double calculateYearlyInterest() {
        return accBalance * 1 * (RATE_OF_INTEREST + ADDITONAL_INTEREST_RATE) / 100;
    }

    void displayFeatures() {
        System.out.println("Additional " + ADDITONAL_INTEREST_RATE + " Interest rate for a new account in ICICI");
    }

}

public class Interface1 {
    public static void main(String[] args) {
        SBIAccount sbi = new SBIAccount(123, "Karan Seth", 100);
        ICICIAccount icici = new ICICIAccount(124, "Karan Seth", 100);
        System.out.println("----------------------------------------------------------------");
        System.out.println(sbi);
        System.out.println(sbi.deposit(200) + " Amount credited to the account!!! ");
        sbi.showBalance();
        System.out.println(sbi.withdraw(100) + " Amount debited from the account!!! ");
        sbi.showBalance();
        System.out.println("Yearly Interest: " + sbi.calculateYearlyInterest());
        sbi.displayFeatures();
        System.out.println("----------------------------------------------------------------");
        System.out.println(icici);
        System.out.println(icici.deposit(200) + " Amount credited to the account!!! ");
        icici.showBalance();
        System.out.println(icici.withdraw(100) + " Amount debited from the account!!! ");
        icici.showBalance();
        System.out.println("Yearly Interest: " + icici.calculateYearlyInterest());
        icici.displayFeatures();
    }
}
