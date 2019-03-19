package rmugattarov.bad_interview;

import java.util.ArrayList;
import java.util.List;

public class No11 {
    public static void main(String[] args) {
        List longs = new ArrayList<Long>();
        longs.add(1L);
        longs.add(1.0);
        longs.add(new Object());
        longs.add("string");

        System.out.println(longs.size());
    }
}
