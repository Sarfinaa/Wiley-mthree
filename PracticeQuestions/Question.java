package PracticeQuestions;

import java.io.IOException;

class Test {

    public int division(int a, int b) throws IOException {
        int result = a / b;
        System.out.println("1");
        return result;
    }
}

public class Question {
    public static void main(String[] args) {
        Test test = new Test();
        try {
            System.out.println(test.division(4, 2));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
