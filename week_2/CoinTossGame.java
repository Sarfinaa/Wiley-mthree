package week_2;

import java.util.Scanner;

class Coin {
    String sideUp;
    double value;
    String coinName;

    Coin() {
        toss();
    }

    Coin(double value, String coinName) {
        toss();
        this.value = value;
        this.coinName = coinName;
    }

    double getValue() {
        return value;
    }

    String random() {
        return (int) (Math.random() * 2) == 0 ? "heads" : "tails";
    }

    void toss() {
        sideUp = random();
    }

    String getSideUp() {
        return sideUp;
    }

}

public class CoinTossGame {
    static double balance = 0;

    public static Coin selectRandomCoin(Coin[] coins) {
        return coins[(int) (Math.random() * 3)];
    }

    public static boolean gameFinished(Scanner s, boolean won) {
        String result = won ? "Congratulations you Won the game!!!" : "You Lost the game!!!";
        System.out.println(result);
        System.out.print("Do you want to play again(y/n)!!! : ");
        if (s.next().equals("y")) {
            balance = 0;
            System.out.println("-----------------------------");
            System.out.println("    !!! NEW GAME !!!");
            return true;
        } else {
            System.out.println("    !!!Game Finished!!!");
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Coin[] coins = new Coin[3];
        coins[0] = new Coin(0.25, "quarter");
        coins[1] = new Coin(0.10, "dime");
        coins[2] = new Coin(0.05, "nickel");
        String space = "-----------------------------";
        System.out.println(space);
        System.out.println("!!!GAME BEGINS!!!");
        while (balance < 1.0) {
            System.out.print("Enter 1 to draw a coin: ");
            String input = s.next();
            if (input.equals("1")) {
                Coin coin = selectRandomCoin(coins);

                System.out.println("You got " + coin.coinName + " coin !!!");
                System.out.print("Enter any key to toss the coin:");
                s.next();
                coin.toss();
                if (coin.getSideUp().equals("heads")) {
                    System.out.println("You got heads and $" + coin.getValue() + " is added to your balance.");
                    balance += coin.getValue();
                } else {
                    System.out.println("You got tails and no amount is added !!!");
                }
                System.out.println(String.format("Balance : %.2f", balance));
                // if the balane is $1 and you didn't want to play again then it terminates the
                // loop
                // ||
                // you lost he game and didn't want to play then it also terminate the loop
                if ((balance == 1.0 && !gameFinished(s, true)) || (balance > 1.0 && !gameFinished(s, false))) {
                    break;
                }

            } else
                System.out.println("ENTER A VALID INPUT!!!");

        }

    }

}
