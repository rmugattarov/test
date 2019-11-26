package rmugattarov.strings;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class LevenshteinDiff {
    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String s1 = RandomStringUtils.random(R.nextInt(6), "abc");
            String s2 = RandomStringUtils.random(R.nextInt(6), "abc");
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(levenshteinDiff(s1, 0, s2, 0));
        }
    }

    public static int levenshteinDiff(String s1, int i1, String s2, int i2) {
        int s1remain = s1.length() - i1;
        int s2remain = s2.length() - i2;
        if (s1remain == 0 && s2remain == 0) return 0;
        else if (s1remain == 0) return s2remain;
        else if (s2remain == 0) return s1remain;
        int diff1 = levenshteinDiff(s1, i1 + 1, s2, i2) + 1;
        int diff2 = levenshteinDiff(s1, i1, s2, i2 + 1) + 1;
        int diff3 = levenshteinDiff(s1, i1 + 1, s2, i2 + 1) + (s1.charAt(i1) == s2.charAt(i2) ? 0 : 1);
        return Math.min(Math.min(diff1, diff2), diff3);
    }
}
