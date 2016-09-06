package rmugattarov.concurrency;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rmugattarov on 15.06.2016.
 */
public class CheckedOutKeys {
    private static final Map<String, String> table = new HashMap<>();

    public static void main(String[] args) {
        table.put("A", "A");
        Thread threadA = new Thread(() -> {
            String val = table.get("A");
            long threadId = Thread.currentThread().getId();
            System.out.println(threadId + ": " + val);
            System.out.println(threadId + ": sleeping");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadId + ": woke up");
            table.put("A", "AA");
            System.out.println(threadId + ": put AA");
        });
        threadA.start();
        Thread threadB = new Thread(() -> {
            String val = table.get("A");
            long threadId = Thread.currentThread().getId();
            System.out.println(threadId + ": " + val);
            table.put("A", "B");
            System.out.println(threadId + ": put B");
        });
        threadB.start();
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main: " + table.get("A"));
    }
}
