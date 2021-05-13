package rmugattarov.yndx.y2021;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class RemoveDupsFromSorted {
    public static void main(String[] args) throws IOException {
        byte[] prev = new byte[16];
        byte[] next = ByteBuffer.allocate(16).putInt(1000001).array();
        nextInt(System.in, next);
        int n = Integer.parseInt(new String(next).trim());
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("output.txt"))) {
            for (int i = 0; i < n; i++) {
                nextInt(System.in, next);
                if (!Arrays.equals(prev, next)) {
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