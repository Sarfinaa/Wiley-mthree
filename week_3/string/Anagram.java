package week_3.string;

public class Anagram {
    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.replace(" ", "").toLowerCase();
        str2 = str2.replace(" ", "").toLowerCase();
        if (str1.length() != str2.length())
            return false;
        int[] hash = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            hash[str1.charAt(i) - 'a']++;
            hash[str2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "Tom Marvolo Riddle";
        String str2 = "I am Lord Voldemort";
        System.out.println(isAnagram(str1, str2));
    }
}
