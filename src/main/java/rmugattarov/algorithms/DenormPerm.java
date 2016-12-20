package rmugattarov.algorithms;

/**
 * Created by rmugattarov on 20.12.2016.
 */
public class DenormPerm {
    public static void main(String[] args) {

    }

    private static void denorm(int[] idx, int denormVal) {
        int mid = idx.length / 2;
        int countdouwn = denormVal;
        int pendulum = 0;
        while (countdouwn > 0) {
            int pivot = mid + pendulum;
            if (pivot < 0 || pivot >= idx.length) {
                pendulum = 0;
                pivot = mid;
            }

        }
    }
}
