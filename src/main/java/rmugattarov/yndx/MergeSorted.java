package rmugattarov.yndx;

import java.io.*;
import java.util.Arrays;

public class MergeSorted {
    public static void main(String[] args) throws IOException {
        String[] fileNames = {
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_1.txt",
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_2.txt",
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_3.txt",
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_4.txt",
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_5.txt",
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_6.txt",
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_7.txt"
        };

        for (String fileName : fileNames) {
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
                 BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("output.txt"))) {
                getStatsAndPrint(in, out);
            }
        }

//        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("input.txt"));
//             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("output.txt"))) {
//            getStatsAndPrint(in, out);
//        }
//        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("input.txt"))) {
//            getStatsAndPrint(in);
//        }
//        getStatsAndPrint(System.in);
    }

    private static void getStatsAndPrint(InputStream in, OutputStream out) throws IOException {
        byte[] nextBytes = new byte[8];
        int k = nextInt(in, nextBytes);
        short[] stats = new short[101];
        for (int i = 0; i < k; i++) {
            int len = nextInt(in, nextBytes);
            for (int j = 0; j < len; j++) {
                byte next = nextByte(in, nextBytes);
                stats[next] = (short) (stats[next] + 1);
            }
        }
        for (byte i = 0; i < stats.length; i++) {
            short val = stats[i];
            while (val-- > 0) {
                if (i == 100) {
                    out.write(49);
                    out.write(48);
                    out.write(48);
                } else if (i > 9) {
                    out.write(i / 10 + 48);
                    out.write(i % 10 + 48);
                } else {
                    out.write(i + 48);
                }
                out.write(32);
            }
        }
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
