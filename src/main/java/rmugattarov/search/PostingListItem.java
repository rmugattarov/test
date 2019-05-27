package rmugattarov.search;

import lombok.Value;

import java.util.List;

@Value
public class PostingListItem {
    Integer docId;
    Integer termFrequency;
    List<Integer> postingPositions;
}
