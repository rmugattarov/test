package rmugattarov.yndx.y2021;

import java.util.Scanner;

public class BinearyArrayOnes1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int lines = s.nextInt();
        int result = 0;
        int running = 0;
        while(lines-- > 0) {
            if (s.nextInt() == 1) {
                running++;
                result = Math.max(result, running);
            } else {
                running = 0;
            }
        }
        System.out.print(result);
    }
}