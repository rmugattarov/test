package rmugattarov.threads;

public class AllThreads {
    public static void main(String[] args) {
        printAllThreads();
    }

    public static void printAllThreads() {
        Thread.getAllStackTraces()
                .keySet()
                .forEach(System.out::println);
    }
}
