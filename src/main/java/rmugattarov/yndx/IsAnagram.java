package rmugattarov.yndx;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class IsAnagram {
    private static final ThreadLocalRandom R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            String s1 = randomString();
            String s2 = R.nextInt(2) == 0 ? AnagramGenerator.shuffle(s1) : randomString();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(isAnagram(s1, s2));
        }
    }

    private static String randomString() {
        return RandomStringUtils.randomAlphabetic(R.nextInt(6));
    }

    public static boolean isAnagram(String s1, String s2) {
        return Arrays.equals(getStringStats(s1), getStringStats(s2));
    }

    private static int[] getStringStats(String s) {
        int[] stats = new int[256];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            stats[c] = stats[c] + 1;
        }
        return stats;
    }
}
