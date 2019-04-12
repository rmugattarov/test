package rmugattarov.crack;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }
}
