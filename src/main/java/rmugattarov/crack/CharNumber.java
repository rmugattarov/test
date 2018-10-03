package rmugattarov.crack;

import org.apache.commons.lang.RandomStringUtils;

public class CharNumber {
    public static void main(String[] args) {
        System.out.println("a" + " : " + (int) 'a' + " : " + Character.getNumericValue('a'));
        for (int i = 0; i < 10; i++) {
            String s = RandomStringUtils.randomAscii(1);
            char c = s.charAt(0);
            System.out.println(s + " : " + (int) c + " : " + Character.getNumericValue(c));
        }
    }
}
