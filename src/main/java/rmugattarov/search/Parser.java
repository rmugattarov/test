package rmugattarov.search;

import java.util.List;

public class Parser {
    public static void parse(InvertedIndex index, Document doc) {
        List<String> tokens = Tokenizer.tokenize(doc.getValue());
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
        }
    }
}
