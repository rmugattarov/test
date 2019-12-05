package rmugattarov.streams;

import rmugattarov.threads.AllThreads;

import java.util.stream.IntStream;

public class ParaStream1 {
    public static void main(String[] args) {
        AllThreads.printAllThreads();
        System.out.println("===");
        IntStream.rangeClosed(1, 1000000)
                .parallel()
                .filter(i -> i % 1000 == 0)
                .forEach(i -> System.out.println(i + " " + Thread.currentThread().getName()));
        System.out.println("===");
        AllThreads.printAllThreads();
    }
}
