package rmugattarov.crack;

import java.util.concurrent.CompletableFuture;

public class ComplFuture {
    private static int i = 0;

    public static void main(String[] args) {
        System.out.println("Start Thread: " + Thread.currentThread().getName());
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello Thread: i : " + i++ + " " + Thread.currentThread().getName());
            return "Hello!";
        }).thenAccept(s -> {
            System.out.println("Accepting Thread: " + Thread.currentThread().getName());
            System.out.println("Accepted: " + s);
        });
        System.out.println("i : " + i + " Thread: " + Thread.currentThread().getName());
        System.out.println("End. Thread: " + Thread.currentThread().getName());
    }
}
