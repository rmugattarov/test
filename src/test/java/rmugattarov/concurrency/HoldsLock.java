package rmugattarov.concurrency;

import org.junit.Test;

/**
 * Created by rmugattarov on 17.05.2016.
 */
public class HoldsLock {
    synchronized public static void main(String[] argg) {
        System.out.println(Thread.holdsLock(HoldsLock.class));
    }

    @Test
    public void test() {
        System.out.println(Thread.holdsLock(this));
        Object o = new Object();
        synchronized (o) {
            System.out.println(Thread.holdsLock(o));
        }
    }
}
