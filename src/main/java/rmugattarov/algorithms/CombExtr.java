package rmugattarov.algorithms;

/**
 * Created by rmugattarov on 08.12.2016.
 */
public class CombExtr {

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

    public boolean hasNext() {
        return idx[0] != data.length - idx.length;
    }


    public static void main(String[] args) {
        CombExtr extr = new CombExtr(new Integer[]{1, 2, 3}, 2);
        System.out.println(extr.hasNext());
    }
}
