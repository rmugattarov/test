package rmugattarov.algorithms;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by rmugattarov on 08.12.2016.
 */
public class CombExtr implements Iterator<Object[]> {

    private final Object[] data;
    private final int[] idx;

    public CombExtr(Object[] data, int len) {
        this.data = data;
        if (len > data.length) {
            len = data.length;
        }
        idx = new int[len];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
    }

    @Override
    public boolean hasNext() {
        return idx[0] != data.length - idx.length;
    }

    @Override
    public Object[] next() {
        Object[] result = new Object[idx.length];
        for (int i = 0; i < idx.length; i++) {
            result[i] = data[idx[i]];
        }
        return result;
    }


    public static void main(String[] args) {
        CombExtr extr = new CombExtr(new Integer[]{1, 2, 3}, 2);
        if (extr.hasNext()) {
            System.out.println(Arrays.toString(extr.next()));
        }
    }
}
