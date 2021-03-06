package rmugattarov.regex;

import java.util.Random;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LonnestZeroGap {
    public static void main(String[] args) {
        int intVal = new Random().nextInt();
        String s = Integer.toString(intVal, 2);
        System.out.println(s);
        System.out.println("length : " + s.length());
        Pattern pattern = Pattern.compile("(1[0]+)(?=1)");
        Matcher matcher = pattern.matcher(s);
        int result = 0;
        while (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            result = Math.max(result, matchResult.group(1).length() - 1);
        }
        System.out.println("Longest gap for " + s + " is " + result);
    }
}
