package rmugattarov.yndx.y2021;

import java.util.Scanner;

public class Parenths1 {
    public static void main(String[] args) {
        char[] chars = new char[new Scanner(System.in).nextInt() * 2];
        parens(chars, 0, 0);
    }

    private static void parens(char[] chars, int open, int closed) {
        int i = open + closed;
        if (i == chars.length) {
            System.out.println(chars);
            return;
        }
        if (open < chars.length / 2) {
            chars[i] = '(';
            parens(chars, open + 1, closed);
        }
        if (closed < open) {
            chars[i] = ')';
            parens(chars, open, closed + 1);
        }
    }
}
