package rmugattarov.random;

import org.apache.commons.lang.math.RandomUtils;

public final class RandomUtil {
    public static int[] getRandomSortedArray() {
        int len = RandomUtils.nextInt(17);
        if (len == 0) return new int[0];
        int[] res = new int[len];
        res[0] = RandomUtils.nextInt(10);
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + RandomUtils.nextInt(10);
        }
        return res;
    }
    public static int[] getRandomSortedUniqueElementsArray() {
        int len = RandomUtils.nextInt(17);
        if (len == 0) return new int[0];
        int[] res = new int[len];
        res[0] = RandomUtils.nextInt(10);
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + RandomUtils.nextInt(9) + 1;
        }
        return res;
    }

    public static int[] getRandomArray() {
        int len = RandomUtils.nextInt(17);
        if (len == 0) return new int[0];
        int[] res = new int[len];
        for (int i = 0; i < res.length; i++) {
            res[i] = RandomUtils.nextInt(9) + 1;
        }
        return res;
    }

}
