package rmugattarov.equals;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by rmugattarov on 14.09.2016.
 */
public class LinkedHashMapEquality {
    public static void main(String[] args) {
        Map<String, String> map1 = new LinkedHashMap<>();
        Map<String, String> map2 = new LinkedHashMap<>();
        map1.put("1", "1");
        map1.put("2", "2");
        map1.put("3", "3");
        map2.put("1", "1");
        map2.put("2", "2");
        map2.put("3", "3");
        map2.put("4", "3");
        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map1.equals(map2));
    }
}
