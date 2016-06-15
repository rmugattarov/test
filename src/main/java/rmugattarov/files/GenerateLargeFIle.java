package rmugattarov.files;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Random;

/**
 * Created by rmugattarov on 14.06.2016.
 */
public class GenerateLargeFile {
    private static final Random rand = new Random();
    private static final String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public static void main(String[] args) throws IOException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\test-large-file.txt"))))) {
            for (int i = 0; i < 300000000; i++) {
                writer.println(generateFileLine());
            }
        }
    }

    private static String generateFileLine() {
        StringBuilder result = new StringBuilder("INSTRUMENT");
        Integer instrumentNumber = rand.nextInt(10) + 1;
        result.append(instrumentNumber).append(",");
        int randomDate = rand.nextInt(27) + 1;
        String date = randomDate < 10 ? "0" + randomDate : randomDate + "";
        result.append(date).append("-");
        String month = months[rand.nextInt(12)];
        result.append(month).append("-");
        Integer year = 1900 + rand.nextInt(115);
        result.append(year).append(",");
        Double value = rand.nextInt(10) + rand.nextDouble();
        result.append(value);
        return result.toString();
    }
}
