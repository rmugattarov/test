package rmugattarov.search;

import java.util.*;

public final class Search {
    public static void proximitySearch(String query, int proximity, InvertedIndex index) {
        List<String> terms = Tokenizer.tokenize(query);
        List<PostingList> pls = index.getPostingLists(terms);
        if (pls.size() < 2) {
            System.out.println(pls);
        }
        if (pls.size() == 2) {
            SortedMap<Integer, SortedSet<Integer>> pl1 = pls.get(0).getDocIdToPostingPositions();
            SortedMap<Integer, SortedSet<Integer>> pl2 = pls.get(1).getDocIdToPostingPositions();
            Iterator<Integer> docIt1 = pl1.keySet().iterator();
            Iterator<Integer> docIt2 = pl2.keySet().iterator();
            Integer docId1 = next(docIt1);
            Integer docId2 = next(docIt2);
            while (docId1 != null && docId2 != null) {
                int docComparison = docId1.compareTo(docId2);
                if (docComparison == 0) {
                    Iterator<Integer> ppIt1 = pl1.get(docId1).iterator();
                    Iterator<Integer> ppIt2 = pl2.get(docId1).iterator();
                    Integer pp1 = next(ppIt1);
                    Integer pp2 = next(ppIt2);
                    while (pp1 != null) {
                        while (pp2 != null) {
                            if (Math.abs(pp1 - pp2) <= proximity) {
                                System.out.println("doc " + docId1 + " pos " + pp1 + "," + pp2);
                            } else if (pp2 > pp1) {
                                break;
                            }
                            pp2 = next(ppIt2);
                        }
                        pp1 = next(ppIt1);
                        ppIt2 = pl2.get(docId1).iterator();
                        pp2 = next(ppIt2);
                    }
                    docId1 = next(docIt1);
                    docId2 = next(docIt2);
                } else if (docComparison > 0) {
                    docId2 = next(docIt2);
                } else {
                    docId1 = next(docIt1);
                }
            }
        }
    }

    private static <T> T next(Iterator<T> it) {
        return it.hasNext() ? it.next() : null;
    }
}
