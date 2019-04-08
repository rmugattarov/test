package rmugattarov.memory;

import java.util.LinkedList;
import java.util.List;

public class MemDebugTest {
    public static void main(String[] args) {
        new Thread(() -> {
            List<String> list = new LinkedList<>();
            while(true) {
                list.add(new String(""));
                new String("");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
