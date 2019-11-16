package rmugattarov.search;

import lombok.Value;

@Value
public class ProximityIntersection {
    Integer docId;
    Integer pos1;
    Integer pos2;
}
