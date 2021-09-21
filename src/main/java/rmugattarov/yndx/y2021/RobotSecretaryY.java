package rmugattarov.yndx.y2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.Math.min;

public class RobotSecretaryY {
    public static void main(String[] args) throws IOException {
//        String input = Files.readAllLines(Paths.get("input.txt")).get(0);
        String input = "Hello World";
//        String input = "APPLE II";
        int n = input.length();
        int[] arr0 = new int[n + 1];
        int[] arr1 = new int[n + 1];
        arr1[0] = 2 * n + 2;

        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                arr1[i + 1] = arr1[i] + 1;
                arr0[i + 1] = min(arr0[i], arr1[i] + 2);
            } else if (c >= 'A' && c <= 'Z') {
                arr0[i + 1] = arr0[i] + 1;
                arr1[i + 1] = min(arr1[i], arr0[i] + 2);
            } else {
                arr0[i + 1] = arr0[i];
                arr1[i + 1] = arr1[i];
            }
        }
        System.out.println(min(arr0[n], arr1[n]) + n);
    }
}
