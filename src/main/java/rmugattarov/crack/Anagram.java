package rmugattarov.crack;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s1;
        String s2;
        s1 = "";
        s2 = "";
        System.out.println(s1 + " - " + s2 + isAnagagram(s1, s2));
        s1 = "abc";
        s2 = "cab";
        System.out.println(s1 + " - " + s2 + " : " + isAnagagram(s1, s2));
        s1 = "abc";
        s2 = "aba";
        System.out.println(s1 + " - " + s2 + " : " + isAnagagram(s1, s2));
    }

    private static boolean isAnagagram(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return String.valueOf(chars1).equals(String.valueOf(chars2));
    }
}
