package week_4.serialization;

import java.io.Serializable;

public class BankAccount implements Serializable {
    int accNo;
    String accHolders;
    int accBalance;

    BankAccount(int accNo, String accHolders, int accBalance) {
        this.accNo = accNo;
        this.accHolders = accHolders;
        this.accBalance = accBalance;
    }

    @Override
    public String toString() {
        return "BankAccount [accBalance=" + accBalance + ", accHolders=" + accHolders + ", accNo=" + accNo + "]";
    }

    int displayBalance(BankAccount account) {
        return account.accBalance;
    }

}
