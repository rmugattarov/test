package rmugattarov.collections;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, Object> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(Integer.MAX_VALUE, new Object());
        }
    }
}
