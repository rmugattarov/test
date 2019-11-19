package rmugattarov.yndx;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MergeSorted {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner("4\n" +
//                "6 2 26 64 88 96 96\n" +
//                "4 8 20 65 86\n" +
//                "7 1 4 16 42 58 61 69\n" +
//                "1 84");
//        Scanner sc = new Scanner(System.in);
//        try (FileInputStream fis = new FileInputStream("C:\\Users\\mugat\\IdeaProjects\\test\\src\\main\\java\\rmugattarov\\yndx\\input_merge_sorted.txt")) {
        try (FileInputStream fis = new FileInputStream("input.txt")) {
            int k = nextInt(fis);
            int[] res = new int[0];
            for (int i = 0; i < k; i++) {
                int len = nextInt(fis);
                int[] next = new int[len];
                for (int j = 0; j < len; j++) {
                    next[j] = nextInt(fis);
                }
                res = merge(res, next);
            }
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]);
                if (i < res.length - 1) System.out.print(' ');
            }
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

    private static int nextInt(InputStream is) throws IOException {
        byte b;
        byte i = 0;
        byte[] bytes = new byte[8];
        while (true) {
            b = (byte) is.read();
            if (b == (byte) 10) continue;
            if (b == (byte) 13) break;
            if (b == (byte) -1) break;
            if (b == (byte) 32) break;
            bytes[i++] = b;
        }
        byte[] res = new byte[i];
        System.arraycopy(bytes, 0, res, 0, i);
        return Integer.valueOf(new String(res).trim());
    }
}
