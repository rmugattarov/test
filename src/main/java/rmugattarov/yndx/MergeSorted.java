package rmugattarov.yndx;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MergeSorted {
    public static void main(String[] args) throws IOException {
        byte[] nextBytes = new byte[8];
        int k = nextInt(System.in, nextBytes);
        int[] res = new int[0];
        for (int i = 0; i < k; i++) {
            int len = nextInt(System.in, nextBytes);
            int[] nextArr = new int[len];
            for (int j = 0; j < len; j++) {
                nextArr[j] = nextInt(System.in, nextBytes);
            }
            res = merge(res, nextArr);
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            System.out.print(' ');
        }
    }

    private static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int ai = 0;
        int bi = 0;
        for (int i = 0; i < res.length; i++) {
            if (ai == a.length) {
                res[i] = b[bi++];
            } else if (bi == b.length) {
                res[i] = a[ai++];
            } else if (a[ai] < b[bi]) {
                res[i] = a[ai++];
            } else {
                res[i] = b[bi++];
            }
        }
        return res;
    }

    private static int nextInt(InputStream is, byte[] bytes) throws IOException {
        Arrays.fill(bytes, (byte) 0);
        byte b;
        byte i = 0;
        while (true) {
            b = (byte) is.read();
            if (i == 0 && (b < 48 || b > 57)) continue;
            if (b < 48 || b > 57) break;
            bytes[i++] = b;
        }
        int res = 0;
        int order = 1;
        while (--i >= 0) {
            res += (bytes[i] - 48) * order;
            order *= 10;
        }
        return res;
    }
}
