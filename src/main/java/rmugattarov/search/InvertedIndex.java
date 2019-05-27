package rmugattarov.search;

import lombok.ToString;

import java.util.SortedMap;
import java.util.TreeMap;

@ToString
public class InvertedIndex {
    private SortedMap<String, PostingList> dict = new TreeMap<>();

    public void add(String term, PostingList pl) {
        PostingList postingList = dict.get(term);
        if (postingList == null) {
            dict.put(term, pl);
        } else {
            postingList.add(pl);
            dict.put(term, postingList);
        }
    }
}
