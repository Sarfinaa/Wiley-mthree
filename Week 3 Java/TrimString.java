public class TrimString {
    public static void main(String[] args) {
        String str = " hello world ";
        String result = "";
        int i = 0;
        while (str.charAt(i) == ' ') {
            i++;
        }
        int j = str.length() - 1;
        while (str.charAt(j) == ' ') {
            j--;
        }
        for (int k = i; k <= j; k++) {
            result += str.charAt(k);
        }
        System.out.println("Originial String:" + str + "\nOriginal String Length:" + str.length());
        System.out.println("Trimmed String:" + result + "\nTrimmed String Length:" + result.length());

    }
}
