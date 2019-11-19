package rmugattarov.yndx;

import java.util.concurrent.atomic.AtomicInteger;

public class Parenths {
    public static void main(String[] args) {
        parens("", 0, 0, 1, new AtomicInteger(0));
        parens("", 0, 0, 2, new AtomicInteger(0));
        parens("", 0, 0, 3, new AtomicInteger(0));
        parens("", 0, 0, 4, new AtomicInteger(0));
        parens("", 0, 0, 5, new AtomicInteger(0));
    }

    private static void parens(String s, int open, int closed, int n, AtomicInteger count) {
        if (s.length() == 2*n) {
            System.out.println(count.incrementAndGet() + ") " + s);
            return;
        }
        if(open < n) {
            parens(s + "(", open + 1, closed, n, count);
        }
        if (closed < open) {
            parens(s + ")", open, closed + 1, n, count);
        }
    }
}
