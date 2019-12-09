package rmugattarov.yndx;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CollapseLetters {
    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String s = getString();
            System.out.println(s);
            System.out.println(collapse(s));
        }
    }

    public static String collapse(String s) {
        if (s.length() < 2) return s;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) == s.charAt(i)) {
                count++;
            } else if (count > 1) {
                sb.append(s.charAt(i));
                sb.append(count);
                count = 1;
            } else {
                sb.append(s.charAt(i));
            }
        }
        if (count > 1) {
            sb.append(s.charAt(s.length() - 1));
            sb.append(count);
        } else {
            sb.append(s.charAt(s.length() - 1));
        }
        return sb.toString();
    }

    public static String getString() {
        int len = R.nextInt(12);
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = (char) (65 + R.nextInt(3));
        }
        return new String(chars);
    }
}
