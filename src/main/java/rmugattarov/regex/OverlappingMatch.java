package rmugattarov.regex;

import java.util.Random;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OverlappingMatch {
    public static void main(String[] args) {
        int intVal = new Random().nextInt();
        String s = Integer.toString(intVal, 2);
        System.out.println(s);
        System.out.println("length : " + s.length());
        Pattern pattern = Pattern.compile("(1[0]+)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            MatchResult matchResult = matcher.toMatchResult();
            System.out.println("group 1 : " + matchResult.group(1));
            System.out.println("group 1 start : " + matchResult.start(1));
            System.out.println("group 1 : end " + matchResult.end(1));
        }
    }
}
