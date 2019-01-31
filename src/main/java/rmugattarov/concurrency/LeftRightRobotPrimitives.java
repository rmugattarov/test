package rmugattarov.concurrency;

public class LeftRightRobotPrimitives {
    public static void main(String[] args) {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("left");
                synchronized (o) {
                    o.notify();
                }
                wait(o);
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                wait(o);
                System.out.println("right");
                synchronized (o) {
                    o.notify();
                }
            }
        });
        t2.start();
        t1.start();
    }

    private static void wait(Object o) {
        synchronized (o) {
            try {
                Thread.sleep(500);
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
