package rmugattarov.search;

import java.util.*;

public class PostingList {
    private SortedMap<Integer, SortedSet<Integer>> docIdToPostingPositions = new TreeMap<>();

    public void add(Integer docId, int postingPosition) {
        SortedSet<Integer> postingPositions = this.docIdToPostingPositions.get(docId);
        if (postingPositions == null) {
            postingPositions = new TreeSet<>();
            postingPositions.add(postingPosition);
            docIdToPostingPositions.put(docId, postingPositions);
        } else {
            postingPositions.add(postingPosition);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry e : docIdToPostingPositions.entrySet()) {
            sb.append("\t").append(e.getKey()).append(" : ").append(e.getValue()).append("\n");
        }
        return sb.toString();
    }
}
