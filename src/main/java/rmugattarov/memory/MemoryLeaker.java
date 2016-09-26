package rmugattarov.memory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rmugattarov on 26.09.2016.
 */
public class MemoryLeaker {
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new LinkedList<>();
        while (true) {
            list.add(new Object());
            Thread.sleep(100);
        }
    }
}
