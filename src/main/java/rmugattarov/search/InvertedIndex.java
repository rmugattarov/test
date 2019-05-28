package rmugattarov.search;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class InvertedIndex {
    private SortedMap<String, PostingList> dict = new TreeMap<>();

    public void add(String term, int docId, int postingPosition) {
        PostingList postingList = dict.get(term);
        if (postingList == null) {
            PostingList pl = new PostingList();
            pl.add(docId, postingPosition);
            dict.put(term, pl);
        } else {
            postingList.add(docId, postingPosition);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Map.Entry<String, PostingList> e: dict.entrySet()) {
            PostingList pl = e.getValue();
            sb.append(i++).append(") ").append(e.getKey()).append(", ").append(pl.getFrequency())
                    .append("\n").append(pl);
        }
        return sb.toString();
    }
}
