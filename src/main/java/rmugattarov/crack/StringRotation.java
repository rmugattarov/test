package rmugattarov.crack;

import java.util.Random;

public class StringRotation {
    private static final Random r = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
//            String randomString = RandomStringUtils.random(5, "abcdefg");
            String randomString = "Hello world!";
            System.out.println(randomString);
            System.out.println(rotate(randomString));
            System.out.println("========");
        }
    }

    public static String rotate(String s) {
        String doubledS = s + s;
        int beginIndex = r.nextInt(s.length());
        return doubledS.substring(beginIndex, beginIndex + s.length());
    }
}
