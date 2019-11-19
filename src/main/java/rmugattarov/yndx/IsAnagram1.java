package rmugattarov.yndx;

import java.util.Arrays;
import java.util.Scanner;

public class IsAnagram1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner("aabc\nbca");
        Scanner sc = new Scanner(System.in);
        if (isAnagram(sc.nextLine(), sc.nextLine())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static boolean isAnagram(String s1, String s2) {
        return Arrays.equals(getStringStats(s1), getStringStats(s2));
    }

    private static int[] getStringStats(String s) {
        int[] stats = new int[256];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            stats[c] = stats[c] + 1;
        }
        return stats;
    }
}
