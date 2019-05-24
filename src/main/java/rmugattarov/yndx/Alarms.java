package rmugattarov.yndx;

import java.util.PriorityQueue;
import java.util.Scanner;

class Alarms {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner("5 7 12\n5 22 17 13 8");
//        Scanner scan = new Scanner("6 5 10\n1 2 3 4 5 6");
//        Scanner scan = new Scanner("5 5 3\n1 1 1 1 1");
//        Scanner scan = new Scanner("2 5 2\n1 100");
//        Scanner scan = new Scanner("4 5 2\n1 100 1 100");
        int n = scan.nextInt();
        long x = (long) scan.nextInt();
        int k = scan.nextInt();

        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add((long) scan.nextInt());
        }

        while (--k > 0) {
            long next = q.remove();
            while (q.peek() != null && q.peek() == next) {
                q.remove();
            }
            q.add(next + x);
        }

        System.out.println(q.peek());
    }
}

//import java.math.BigInteger;
//        import java.util.PriorityQueue;
//        import java.util.Scanner;
//
//class Alarms {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        BigInteger x = BigInteger.valueOf(scan.nextInt());
//        int k = scan.nextInt();
//
//        PriorityQueue<BigInteger> q = new PriorityQueue<>();
//        for (int i = 0; i < n; i++) {
//            q.add(BigInteger.valueOf(scan.nextInt()));
//        }
//        scan.close();
//
//        while (--k > 0) {
//            BigInteger next = q.remove();
//            while (q.peek() != null && q.peek().equals(next)) {
//                q.remove();
//            }
//            q.add(next.add(x));
//        }
//
//        System.out.println(q.peek());
//    }
//}