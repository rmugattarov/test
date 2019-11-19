package rmugattarov.yndx;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Parenths1 {
    public static void main(String[] args) throws IOException {
        char[] chars = new char[new Scanner(System.in).nextInt() * 2];
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("output.txt"))) {
            parens(chars, 0, 0, out);
        }
    }

    private static void parens(char[] chars, int open, int closed, OutputStream out) throws IOException {
        int i = open + closed;
        if (i == chars.length) {
            for (char c : chars) {
                out.write(c);
            }
            out.write(10);
            return;
        }
        if (open < chars.length / 2) {
            chars[i] = '(';
            parens(chars, open + 1, closed, out);
        }
        if (closed < open) {
            chars[i] = ')';
            parens(chars, open, closed + 1, out);
        }
    }
}
