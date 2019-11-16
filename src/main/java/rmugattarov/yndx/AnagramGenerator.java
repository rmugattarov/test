package rmugattarov.yndx;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class AnagramGenerator {
    private static final ThreadLocalRandom R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            String s = RandomStringUtils.randomAlphabetic(R.nextInt(6));
            System.out.println(s);
            System.out.println(shuffle(s));
        }
    }

    public static String shuffle(String s) {
        LinkedList<Character> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            list.add(c);
        }
        while (list.size() > 0) {
            chars[chars.length - list.size()] = list.remove(R.nextInt(list.size()));
        }
        return new String(chars);
    }
}
