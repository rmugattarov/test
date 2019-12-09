package rmugattarov.strings;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class YodaString {
    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String sentence = getSentence();
            System.out.println(sentence);
            System.out.println(yodify(sentence));
            System.out.println("================");
        }
    }

    public static String yodify(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i)==' ') {
                result.append(word);
                result.append(' ');
                word = new StringBuilder();
            } else {
                word.insert(0, s.charAt(i));
            }
        }
        result.append(word);
        return result.toString();
    }

    public static String getSentence() {
        int wordCount = R.nextInt(5);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordCount; i++) {
            sb.append(getWord());
            if (i < wordCount - 1)
                sb.append(' ');
        }
        return sb.toString();
    }

    public static String getWord() {
        int len = R.nextInt(4) + 1;
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = (char) (65 + R.nextInt(3));
        }
        return new String(chars);
    }
}
