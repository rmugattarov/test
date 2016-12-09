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
    private boolean hasNext = true;

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

    private void raise(int i) {
        idx[i] = idx[i] + 1;
        boolean tooBig = idx[i] > data.length - idx.length + i;
        if (i == 0 && tooBig) {
            hasNext = false;
            return;
        } else if (tooBig) {
            raise(i - 1);
        } else {
            for (int j = i + 1; j < idx.length; j++) {
                idx[j] = idx[j - 1] + 1;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public Object[] next() {
        Object[] result = collect(idx);
        raise(lastIdx);
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
