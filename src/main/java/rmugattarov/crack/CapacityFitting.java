package rmugattarov.crack;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CapacityFitting {
    private static final Random R = ThreadLocalRandom.current();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int capacity = R.nextInt(15) + 1;
            System.out.println("Capacity: " + capacity);
            int h;
            int bucket;
            h = new Object().hashCode();
            System.out.println("Hash: " + h);
            bucket = (capacity - 1) & h;
            System.out.println("Bucket: " + bucket);
            h = new Object().hashCode();
            System.out.println("Hash: " + h);
            bucket = (capacity - 1) & h;
            System.out.println("Bucket: " + bucket);
            System.out.println("=============");

        }
    }
}
