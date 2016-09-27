package rmugattarov.memory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rmugattarov on 27.09.2016.
 */
public class JProfilerObjectsRecording {
    private Map<String, String> map0 = new LinkedHashMap<>();
    private Map<String, String> map1 = null;

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        List list = new ArrayList();
        for (int i = 0; i < 200; i++) {
            list.add(new JProfilerObjectsRecording());
            Thread.sleep(100);
        }
    }
}
