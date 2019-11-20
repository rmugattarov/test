package rmugattarov.yndx;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MergeSorted {
    public static void main(String[] args) throws IOException {
        byte[] nextBytes = new byte[8];
        int k = nextInt(System.in, nextBytes);
        byte[] res = new byte[0];
        for (short i = 0; i < k; i++) {
            int len = nextInt(System.in, nextBytes);
            byte[] nextArr = new byte[len];
            for (short j = 0; j < len; j++) {
                nextArr[j] = nextByte(System.in, nextBytes);
            }
            res = merge(res, nextArr);
        }
        for (byte re : res) {
            System.out.print(re);
            System.out.print(' ');
        }
    }

    private static byte[] merge(byte[] a, byte[] b) {
        byte[] res = new byte[a.length + b.length];
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

    private static byte nextByte(InputStream is, byte[] bytes) throws IOException {
        Arrays.fill(bytes, (byte) 0);
        byte b;
        byte i = 0;
        while (true) {
            b = (byte) is.read();
            if (i == 0 && (b < 48 || b > 57)) continue;
            if (b < 48 || b > 57) break;
            bytes[i++] = b;
        }
        byte res = 0;
        byte order = 1;
        while (--i >= 0) {
            res += (bytes[i] - 48) * order;
            order *= 10;
        }
        return res;
    }
}
