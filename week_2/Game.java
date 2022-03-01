package week_2;

import java.lang.Math;
import java.util.Scanner;

public class Game {
    public static int generateRandom() {
        return (int) (Math.random() * 3 + 1);
    }

    public static int generateNumber(String str) {
        switch (str) {
            case "stone":
                return 1;
            case "paper":
                return 2;
            case "sciccor":
                return 3;
            default:
                return 0;
        }
    }

    public static boolean playerWins(int player, int comp) {

        if ((player == 3 && comp == 1) || (player == 2 && comp == 3) || (player == 1 && comp == 2))
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("    !!!STONE PAPER SCISSORS GAME!!!");
        while (true) {
            System.out.print("Enter your choice(stone,paper,sciccor): ");
            int a = generateNumber(s.next());
            int b = generateRandom();
            if (a == b) {
                System.out.println("Its a Draw");
                continue;
            }
            if (playerWins(a, b))
                System.out.println("Congratulations you won the game!!!");
            else
                System.out.println("You Lost the game!!!");
            System.out.print("Wanna Play Again(yes/no): ");
            if (s.next().equals("no"))
                break;
        }

    }
}
