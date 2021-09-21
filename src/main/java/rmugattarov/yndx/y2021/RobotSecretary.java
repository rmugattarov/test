package rmugattarov.yndx.y2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RobotSecretary {

    private static int sum = Integer.MAX_VALUE;
    private static int spaces = 0;

    public static void main(String[] args) throws IOException {
        String input = Files.readAllLines(Paths.get("input.txt")).get(0);
//        String input = "Hello World";
//        String input = "APPLE II";
        input = removeSpaces(input);
        System.out.println(spaces + sum(0, input, true, 0));
    }

    private static String removeSpaces(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                spaces++;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static int sum(int i, String input, boolean lowerReg, int sum) {
        if (sum >= RobotSecretary.sum) return sum;
        if (i == input.length()) {
            RobotSecretary.sum = sum;
            return sum;
        }
        char c = input.charAt(i);
        boolean lowercase = isLowercase(c);
        if (c == ' ' || (lowercase && lowerReg) || (!lowercase && !lowerReg)) {
            return sum(i + 1, input, lowerReg, sum + 1);
        } else {
            return Math.min(sum(i + 1, input, lowerReg, sum + 2), sum(i + 1, input, !lowerReg, sum + 3));
        }
    }

    private static boolean isLowercase(char c) {
        return c >= 97 && c <= 122;
    }

}