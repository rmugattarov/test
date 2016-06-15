package rmugattarov.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by rmugattarov on 15.06.2016.
 */
public class ReadLargeFile {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new FileInputStream("D:\\test-large-file.txt"))) {
            long lineCount = 0;
            while (scanner.hasNextLine()) {
                System.out.printf("%d) %s\r\n", ++lineCount, scanner.nextLine());
            }
        }
    }
}
