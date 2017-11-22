package rmugattarov.algorithms;

public class EuclidMaxDiv {
    public static void main(String[] args) {
        System.out.println(maxDiv(2166, 6099));
    }

    private static int maxDiv(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        int r = m  % n;
        if (r == 0) {
            return n;
        } else {
            return maxDiv(n, r);
        }
    }
}
