package rmugattarov.yndx;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIn {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("input.txt"));
        FileWriter writer = new FileWriter("output.txt");
        writer.write((scan.nextInt() + scan.nextInt()) + "");
        scan.close();
        writer.close();
    }
}
