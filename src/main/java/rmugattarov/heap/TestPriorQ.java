package rmugattarov.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestPriorQ {
    private static final Random R = ThreadLocalRandom.current();
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < 10; i++) {
            q.add(R.nextInt(10));
        }
        System.out.println(q);
        while(!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
