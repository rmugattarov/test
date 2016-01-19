package rmugattarov.json;

import org.json.JSONObject;
import org.junit.Test;

/**
 * Created by rmugattarov on 19.01.2016.
 */
public class JsonTest {
    @Test
    public void test_json() {
        JSONObject jsonObject = new JSONObject();
        System.out.printf("empty object : %s\n", jsonObject);
        jsonObject.put("rowCount", 13000);
        System.out.printf("int value : %s\n", jsonObject);

    }
}
