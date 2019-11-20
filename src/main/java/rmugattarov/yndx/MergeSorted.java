package rmugattarov.yndx;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MergeSorted {
    public static void main(String[] args) throws IOException {
        String[] fileNames = {
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_1.txt",
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_2.txt",
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_3.txt",
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_4.txt",
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_5.txt",
                "C:\\Users\\mugat\\IdeaProjects\\test\\merge_sorted_test_cases\\input_6.txt"
        };

        for (String fileName : fileNames) {
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName))) {
                mergeAndPrint(in);
                System.out.println();
            }
        }
//        try(BufferedInputStream in = new BufferedInputStream(new FileInputStream("input.txt"))) {
//            mergeAndPrint(in);
//        }
    }

    private static void mergeAndPrint(InputStream in) throws IOException {
        byte[] nextBytes = new byte[8];
        int k = nextInt(in, nextBytes);
        byte[] res = new byte[k * k * 10];
        int resI = 0;
        int totalLen = 0;
        for (int i = 0; i < k; i++) {
            int len = nextInt(in, nextBytes);
            totalLen += len;
            for (int j = 0; j < len; j++) {
                res[resI++] = nextByte(in, nextBytes);
            }
        }
        Arrays.sort(res);
        for (int i = res.length - totalLen; i < res.length; i++) {
            System.out.print(res[i]);
            System.out.print(' ');
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
