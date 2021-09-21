package rmugattarov.yndx.y2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RobotSecretary {

    private static int sum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        String input = Files.readAllLines(Paths.get("input.txt")).get(0);
//        String input = "Hello World";
//        String input = "APPLE II";
        System.out.println(sum(0, input, 0, 0));
    }

    private static int sum(int i, String input, int reg, int sum) {
        if (sum >= RobotSecretary.sum) return sum;
        if (i == input.length()) {
            RobotSecretary.sum = sum;
            return sum;
        }
        char c = input.charAt(i);
        if ((Character.isLowerCase(c) && reg == 0) || (Character.isUpperCase(c) && reg == 1) || c == ' ') {
            return sum(i + 1, input, reg, sum + 1);
        } else {
            return Math.min(sum(i + 1, input, reg, sum + 2), sum(i + 1, input, reg == 0 ? 1 : 0, sum + 3));
        }
    }

}

//    public static void single() throws IOException {
////        String input = Files.readAllLines(Paths.get("input.txt")).get(0);
//        String input = "Hello World";
////        String input = "APPLE II";
////        String input = "AAAaaAaaa";
//        boolean lower = true;
//        int lowerReps = 0;
//        int upperReps = 0;
//        int sum = 0;
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//
//            if (c == ' ') {
//                sum++;
//                continue;
//            }
//
//            if (lower && Character.isLowerCase(c)) {
//                sum++;
//            } else if (!lower && Character.isUpperCase(c)) {
//                sum++;
//            } else {
//                sum += 2;
//            }
//
//            if (Character.isLowerCase(c)) {
//                upperReps = 0;
//                lowerReps++;
//                if (lowerReps == 3 && !lower && (i + 1 == input.length() || Character.isLowerCase(input.charAt(i + 1)))) {
//                    lower = true;
//                }
//            } else if (Character.isUpperCase(c)) {
//                lowerReps = 0;
//                upperReps++;
//                if (upperReps == 3 && lower && (i + 1 == input.length() || Character.isUpperCase(input.charAt(i + 1)))) {
//                    lower = false;
//                }
//            }
//        }
//        System.out.println(sum);
//    }
