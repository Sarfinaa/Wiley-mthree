package week_3.string;
// public static String reverse1(String s) {

//     StringBuilder sb = new StringBuilder(s);
//     int i = 0;
//     int j = sb.length() - 1;
//     while (i <= j) {
//         char c = sb.charAt(i);
//         sb.setCharAt(i, sb.charAt(j));
//         sb.setCharAt(j, c);
//         i++;
//         j--;
//     }
//     return sb.toString();
// }

public class ReverseString {
    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "India Is my country";
        String[] sarr = s.split(" ");
        String ans = "";
        for (String str : sarr) {
            ans = reverse(str) + " " + ans;
        }
        System.out.println("Originial:" + s);
        System.out.println("After Reversing:" + ans);
    }
}
