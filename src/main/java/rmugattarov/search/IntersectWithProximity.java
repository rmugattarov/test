package rmugattarov.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectWithProximity {
    public static void main(String[] args) {
        PostingListItem item1 = new PostingListItem(1, 3, Arrays.asList(1, 9));
        PostingListItem item2 = new PostingListItem(1, 3, Arrays.asList());
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(intersectWithProximity(item1, item2, 1));
    }

    public static List<ProximityIntersection> intersectWithProximity(PostingListItem item1, PostingListItem item2, int proximity) {
        List<ProximityIntersection> result = new ArrayList<>();

        for (int pp1: item1.getPostingPositions()) {
            for (int pp2: item2.getPostingPositions()) {
                if (Math.abs(pp1 - pp2) <= proximity) {
                    result.add(new ProximityIntersection(item1.getDocId(), pp1, pp2));
                } else if (pp2 > pp1) {
                    break;
                }
            }
        }

        return result;
    }
}
