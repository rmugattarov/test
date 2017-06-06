package rmugattarov.functions;

import java.util.function.Consumer;

/**
 * Created by rmugattarov on 06.06.2017.
 */
public class FuncMutithreading {
    public static final Consumer<String> f = arg -> {
        String s = "";
        s += arg;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " : " + arg + " : " + s);
    };

    private static class Task implements Runnable {
        @Override
        public void run() {
            Consumer<String> func = new FuncMutithreading().f;
            System.out.println(Thread.currentThread().getName() + " : " + func.hashCode());
            func.accept(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        Thread t3 = new Thread(new Task());
        t1.start();
        t2.start();
        t3.start();
    }
}
