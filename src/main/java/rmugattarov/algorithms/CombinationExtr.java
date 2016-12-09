package rmugattarov.algorithms;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by rmugattarov on 08.12.2016.
 */
public class CombinationExtr implements Iterator<Object[]> {

    private final Object[] data;
    private final int[] idx;
    private final int lastIdx;

    public CombinationExtr(Object[] data, int len) {
        this.data = data;
        idx = new int[len];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        lastIdx = idx.length - 1;
    }

    public static void main(String[] args) {
        CombinationExtr extr = new CombinationExtr(new Integer[]{1, 2, 3, 4, 5}, 3);
        while (extr.hasNext()) {
            System.out.println(Arrays.toString(extr.next()));
        }
    }

    private void raise(int[] idx, int i) {
        idx[i] = idx[i] + 1;
        if (idx[i] + i >= data.length) {
            raise(idx, i - 1);
        } else {
            for (int j = i + 1; j < idx.length; j++) {
                idx[j] = idx[j - 1] + 1;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return idx[0] < data.length - idx.length;
    }

    @Override
    public Object[] next() {
        Object[] result;
        if (idx[lastIdx] >= data.length) {
            raise(idx, lastIdx - 1);
            result = collect(idx);
        } else {
            result = collect(idx);
        }
        idx[lastIdx] = idx[lastIdx] + 1;
        return result;
    }

    private Object[] collect(int[] idx) {
        Object[] result = new Object[idx.length];
        for (int i = 0; i < idx.length; i++) {
            result[i] = data[idx[i]];
        }
        return result;
    }
}
