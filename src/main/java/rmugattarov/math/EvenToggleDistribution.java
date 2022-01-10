package rmugattarov.math;

import java.util.Random;

public class EvenToggleDistribution {
    public static void main(String[] args) {
        for (int i=0; i<100;i++) {
            toggle(99, 1, false);
        }
    }

    private static void toggle(int oldRouteShare, int newRouteShare, boolean duplicate) {
        Random random = new Random();
        int hit = random.nextInt(oldRouteShare + newRouteShare);

        boolean useOldRoute = hit < oldRouteShare;
        boolean useNewRoute = hit >= oldRouteShare;

        if (useOldRoute) {
            System.out.print("O");
        } else if (useNewRoute) {
            System.out.print("N");
            if (duplicate) {
                System.out.print("O");
            }
        }
    }
}
