package rmugattarov.guava;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by rmugattarov on 09.08.2016.
 */
public class ImmutableMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new ImmutableMap.Builder<String, String>().put("123", "456").put("qwe", "asd").put("zxc", null).build();
        System.out.println(map);
        map.remove("123");
    }
}
