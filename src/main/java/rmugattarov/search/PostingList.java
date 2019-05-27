package rmugattarov.search;

import lombok.ToString;

import java.util.*;

@ToString
public class PostingList {
    private SortedMap<Integer, SortedSet<Integer>> postingPositions = new TreeMap<>();

    public void add(Integer docId, Collection<Integer> postingPositions) {
        SortedSet<Integer> pps = this.postingPositions.get(docId);
        if (pps == null) {
            this.postingPositions.put(docId, new TreeSet<>(postingPositions));
        } else {
            pps.addAll(postingPositions);
        }
    }
}
