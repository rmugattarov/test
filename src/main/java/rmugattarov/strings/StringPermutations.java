package rmugattarov.strings;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class StringPermutations {
    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        String s = RandomStringUtils.random(R.nextInt(6), "abc");
        printStringPermutations(new AtomicInteger(),"", s);
    }

    public static void printStringPermutations(AtomicInteger count, String pref, String post) {
        if (post.length() == 0) System.out.println(count.incrementAndGet() + ") " + pref);
        for (int i = 0; i < post.length(); i++) {
            printStringPermutations(count,pref + post.charAt(i), post.substring(0, i) + post.substring(i + 1));
        }
    }
}
