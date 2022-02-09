import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the marks of maths,physics and chemistry(out of 100): ");
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int n3 = s.nextInt();
        int total = n1 + n2 + n3;
        int gradeVal = total / 3;
        char grade;
        if (gradeVal >= 90)
            grade = 'A';
        else if (gradeVal >= 80)
            grade = 'B';
        else if (gradeVal >= 70)
            grade = 'C';
        else
            grade = 'D';
        System.out.println("Total marks:" + total);
        System.out.println("Grade:" + grade);
    }

}
