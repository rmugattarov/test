package rmugattarov.yndx.y2021;

import java.util.Scanner;
import java.util.BitSet;

public class JewelsAndStones {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String jString = s.nextLine();
        String sString = s.nextLine();
        BitSet jewels = new BitSet(26);
        for (int i=0; i<jString.length(); i++) {
            jewels.set(jString.charAt(i) - 'a');
        }
        int result = 0;
        for (int i=0; i<sString.length(); i++) {
            if (jewels.get(sString.charAt(i) - 'a')) {
                result++;
            }
        }
        System.out.print(result);
    }
}