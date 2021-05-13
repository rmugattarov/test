package rmugattarov.yndx.y2021;

import java.util.Arrays;
import java.io.IOException;

public class IsAnagram1 {
    public static void main(String[] args) throws IOException {
        int[] stats1 = getStats();
        int[] stats2 = getStats();
        System.out.println(Arrays.equals(stats1, stats2) ? 1 : 0);
    }

    private static int[] getStats() throws IOException {
        int[] stats = new int[26];
        int c = System.in.read();
        while (c != '\n' && c != -1) {
            int i = c - 'a';
            stats[i] = stats[i] + 1;
            c = System.in.read();
        }
        return stats;
    }
}
