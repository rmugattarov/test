package rmugattarov.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by rmugattarov on 10.02.2017.
 */
public class EventBudTest {
    private static final EventBus BUS = new EventBus();
    private static class Subscriber {
        {
            BUS.register(this);
        }
        @Subscribe
        public void onMessage(Object o) {
            System.out.println("Subscribe thread : " + Thread.currentThread().getName());
            System.out.println("On message");
        }
    }
    public static void main(String[] args) {
        System.out.println("main thread : " + Thread.currentThread().getName());
        Subscriber s = new Subscriber();
        BUS.post(new Object());
        System.out.println("main end");
    }
}
