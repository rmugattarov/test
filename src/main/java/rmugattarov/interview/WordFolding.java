package rmugattarov.interview;

public class WordFolding {
    public static void main(String[] args) {
        fold("WALMART");
    }

    private static void fold(String s) {
        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = 1; i + j < s.length(); j++) {
                StringBuilder perm = new StringBuilder();
                int k = 0;
                while (k < i) {
                    perm.append(s.charAt(k++));
                }
                perm.append(j);
                k += j;
                while (k < s.length()) {
                    perm.append(s.charAt(k++));
                }
                System.out.println(perm);
            }
        }
    }
}
