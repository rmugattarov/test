package rmugattarov.yndx.y2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.List;

public class ZeroOne {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get("input.txt"));
        String s1 = strings.get(0);
        String s2 = strings.get(1);
//        String s1 = "onezero";
//        String s2 = "oneone";
        System.out.println(compare(parse(s1), parse(s2)));
    }

    private static BitSet parse(String s) {
        BitSet bs = new BitSet();
        int order = 0;
        for (int i = s.length() - 1; i > 0; ) {
            if (s.charAt(i) == 'o') {
                i -= 4;
            } else {
                bs.set(order);
                i -= 3;
            }
            order++;
        }
        return bs;
    }

    private static char compare(BitSet s1, BitSet s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 > l2) {
            return '>';
        } else if (l1 < l2) {
            return '<';
        } else {
            for (int i = l1 - 1; i >= 0; i--) {
                if(s1.get(i) && s2.get(i)) {
                    continue;
                } else if ((!s1.get(i)) && (!s2.get(i))) {
                    continue;
                } else if (s1.get(i)) {
                    return '>';
                } else {
                    return '<';
                }
            }
            return '=';
        }
    }

}
