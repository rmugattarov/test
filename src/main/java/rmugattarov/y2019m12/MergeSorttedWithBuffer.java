package rmugattarov.y2019m12;

import rmugattarov.random.RandomUtil;

import java.util.Arrays;

public class MergeSorttedWithBuffer {
    public static void main(String[] args) {
        int[] temp = RandomUtil.getRandomSortedArray();
        int[] b = RandomUtil.getRandomSortedArray();
        int[] a = new int[temp.length + b.length];
        System.arraycopy(temp, 0, a, 0, temp.length);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        merge(a, temp.length, b);
        System.out.println(Arrays.toString(a));
        int[] check = new int[temp.length + b.length];
        System.arraycopy(temp, 0, check, 0, temp.length);
        System.arraycopy(b, 0, check, temp.length, b.length);
        Arrays.sort(check);
        if (!Arrays.equals(a, check)) throw new RuntimeException("Wrong Answer");
    }

    private static void merge(int[] a, int aLen, int[] b) {
        int ar = aLen - 1;
        int br = b.length - 1;
        int mr = a.length - 1;
        while (br >= 0 || ar >= 0) {
            if (ar >= 0 && br >= 0 && a[ar] >= b[br]) a[mr--] = a[ar--];
            else if (br >= 0) a[mr--] = b[br--];
            else a[mr--] = a[ar--];
        }
    }
}

