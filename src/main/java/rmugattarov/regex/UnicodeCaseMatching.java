package rmugattarov.regex;

public class UnicodeCaseMatching {
    public static void main(String[] args) {
        System.out.println("AbC".matches("abc"));
        System.out.println("AbC".matches("(?i)abc"));
        System.out.println("АбВ".matches("абв"));
        System.out.println("АбВ".matches("(?i)абв"));
        System.out.println("АбВ".matches("(?iu)абв"));
    }
}
