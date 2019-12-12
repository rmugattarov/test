package rmugattarov.concurrency;

public class SyncMetAndUnsync {
    public static void main(String[] args) throws InterruptedException {
        SyncMetAndUnsync o = new SyncMetAndUnsync();
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            o.un();
            o.un();
        });
        Thread t2 = new Thread(()->{
            o.s();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            o.s();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public void un() {
        System.out.println("un " + Thread.currentThread().getName());
        s();
    }

    public synchronized void s() {
        System.out.println("s " + Thread.currentThread().getName());
    }
}
