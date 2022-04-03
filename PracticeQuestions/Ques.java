package PracticeQuestions;

public class Ques {
    public static void main(String[] args) {
        String str = "A boy has a problem";
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == ' ') {
                sb.replace(i, i + 1, "%20");
            }

        }
        System.out.println(sb);
    }
}
