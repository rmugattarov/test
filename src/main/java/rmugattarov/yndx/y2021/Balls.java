package rmugattarov.yndx.y2021;

import java.util.List;
import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner("5\n" +
                "4 5 5 5 5\n" +
                "1 1 1 1 1");
        int colors = sc.nextInt();
        int[] balls = new int[colors];
        int total = 0;
        for (int i = 0; i < colors; i++) {
            balls[i] = sc.nextInt();
            total += balls[i];
        }
        int[] limits = new int[colors];
        for (int i = 0; i < colors; i++) {
            limits[i] = sc.nextInt();
            if (limits[i] > balls[i]) {
                System.out.println(0);
                return;
            }
        }
        int bags = total;
        for (int i = 0; i < colors; i++) {
            int maxBags = balls[i] / limits[i];
            if (maxBags < bags) {
                bags = maxBags;
            }
        }
        int bagSize = total / bags;
        System.out.println(bags + " " + bagSize);

        int color = 0;
        while (total-- > 0) {
            for (int bag = 0; bag < bags; bag++) {

            }
        }
    }
}
