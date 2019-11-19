package rmugattarov.yndx;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class RemoveDupsFromSorted {
    public static void main(String[] args) throws IOException {
        byte[] prev = new byte[64];
        byte[] next = new byte[64];
        nextInt(System.in, next);
        int n = Integer.valueOf(new String(next).trim());
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("output.txt"))) {
            for (int i = 0; i < n; i++) {
                nextInt(System.in, next);
                if (i == 0 || !Arrays.equals(prev, next)) {
                    for (byte b : next) {
                        if (b == 0) break;
                        out.write(b);
                    }
                    out.write(10);
                }
                System.arraycopy(next, 0, prev, 0, next.length);
            }
        }
    }

    private static void nextInt(InputStream is, byte[] bytes) throws IOException {
        Arrays.fill(bytes, (byte) 0);
        byte b;
        byte i = 0;
        while (true) {
            b = (byte) is.read();
            if (b == (byte) 10) break;
            if (b == (byte) 13) break;
            if (b == (byte) -1) break;
            bytes[i++] = b;
        }
    }
}

//    int prev = 0;
//            for (int i = 0; i < n; i++) {
//        int next = Integer.valueOf(reader.readLine());
//        if (i == 0 || next > prev) {
//        System.out.println(next);
//        prev = next;
//        }
//        }

//        while (true) {
//                byte[] b = new byte[8];
//                System.in.read(b, 0, 8);
//                System.out.println(new Integer());
//                }

//    private static byte[] nextInt(InputStream inputStream) throws IOException {
//        byte b;
//        byte i =0;
//        byte[] bytes = new byte[8];
//        while (true) {
//            b = (byte) inputStream.read();
//            if (b == (byte) 13) continue;
//            if (b < (byte) 48 || b > (byte) 57) {
//                break;
//            }
//            bytes[i++] = b;
//        }
//        return bytes;
//    }
