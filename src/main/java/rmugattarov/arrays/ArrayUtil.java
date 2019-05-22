package rmugattarov.arrays;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public final class ArrayUtil {
    public static int[] appendRanges(int[] left, int leftFrom, int leftTo, int[] right, int rightFrom, int rightTo) {
        return ArrayUtils.addAll(Arrays.copyOfRange(left, leftFrom, leftTo), Arrays.copyOfRange(right, rightFrom, rightTo));
    }
}
