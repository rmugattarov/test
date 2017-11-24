package rmugattarov.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemoryReg {
    public static void main(String[] args) {
        String s = "<0x6 0x00000000 0x0 0x40000000>";
        Pattern pattern = Pattern.compile("(\\s?((\\dx\\d+) (\\dx(\\d+)))\\s?)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String group = matcher.group(5);
            System.out.println(group);
            System.out.println(Integer.parseInt(group, 16));
        }
    }
}
