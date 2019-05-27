package rmugattarov.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Tokenizer {
    public static List<String> tokenize(String s) {
        List<String> tokens = new ArrayList<>();
        Scanner scan = new Scanner(s);
        while (scan.hasNext()) {
            tokens.add(normalize(scan.next()));
        }
        return tokens;
    }

    public static String normalize(String s) {
        return s.trim().toLowerCase().replaceAll("[\\W]", "");
    }
}
