package rmugattarov.yndx;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jewelString = sc.nextLine();
        String stoneString = sc.nextLine();
        char[] jewelChars = jewelString.toCharArray();
        Set<Character> jewelSet = new HashSet<>();
        for (char c: jewelChars) {
            jewelSet.add(c);
        }
        char[] stoneChars = stoneString.toCharArray();
        int count = 0;
        for (char c: stoneChars) {
            if (jewelSet.contains(c)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
