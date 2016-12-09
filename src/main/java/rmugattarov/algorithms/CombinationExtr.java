package rmugattarov.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by rmugattarov on 08.12.2016.
 */
public class CombinationExtr<T> implements Iterator<List<T>> {

    private final List<T> data;
    private final int[] idx;
    private boolean hasNext = true;

    public CombinationExtr(List<T> data, int len) {
        this.data = data;
        if (len > data.size()) {
            len = data.size();
        } else if (len < 1) {
            len = 1;
        }
        idx = new int[len];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
    }

    public static void main(String[] args) {
        CombinationExtr extr = new CombinationExtr(Arrays.asList(1, 2, 3, 4, 5), 3);
        while (extr.hasNext()) {
            System.out.println(extr.next());
        }
    }

    private void raise(int i) {
        idx[i] = idx[i] + 1;
        boolean tooBig = idx[i] > data.size() - idx.length + i;
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
    public List<T> next() {
        List<T> result = collect(idx);
        raise(idx.length - 1);
        return result;
    }

    private List<T> collect(int[] idx) {
        List<T> result = new ArrayList<>(idx.length);
        for (int i : idx) {
            result.add(data.get(i));
        }
        return result;
    }
}
