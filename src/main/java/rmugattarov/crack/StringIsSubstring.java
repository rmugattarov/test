package rmugattarov.crack;

public class StringIsSubstring {
    public static void main(String[] args) {
        System.out.println("abc : abc :" + isSubstring("abc", "abc"));
        System.out.println("abc : ab :" + isSubstring("abc", "ab"));
        System.out.println("ab : abc :" + isSubstring("ab", "abc"));
        System.out.println("123 : 456 :" + isSubstring("123", "456"));
        System.out.println(" :  :" + isSubstring("", ""));
        System.out.println("aaabbbccc : bbb :" + isSubstring("aaabbbccc", "bbb"));
    }

    public static boolean isSubstring(String s1, String s2) {
        for (int i = 0; i + s2.length() < s1.length() + 1; i++) {
            if (s1.substring(i, i + s2.length()).equals(s2)) return true;
        }
        return false;
    }
}
