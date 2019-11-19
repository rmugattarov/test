package rmugattarov.yndx;

import java.util.Scanner;

public class BinearyArrayOnes1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner("5\n1\n1\n1\n1\n1");
        int n = sc.nextInt();
        int max = 0;
        int curr = 0;
        for (int i=0; i<n; i++) {
            int next = sc.nextInt();
            if (next > 0) {
                curr++;
                max = Math.max(max, curr);
            } else {
                curr = 0;
            }
        }
        System.out.println(max);
    }
}
