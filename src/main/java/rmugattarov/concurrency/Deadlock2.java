package rmugattarov.concurrency;

public class Deadlock2 {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o1) {
                System.out.println("t1 acqrd o1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("t1 acqrd o2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (o2) {
                System.out.println("t2 acqrd o2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("t2 acqrd o1");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
