package rmugattarov.heap;

import rmugattarov.arrays.ArrayUtil;
import rmugattarov.random.RandomUtil;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] randomArray = RandomUtil.getRandomArray();
            System.out.println(Arrays.toString(randomArray));
            System.out.println(ArrayUtil.isSorted(randomArray));
            BuildHeap.buildHeap(randomArray);
            sortHeap(randomArray, randomArray.length);
            System.out.println(Arrays.toString(randomArray));
            System.out.println(ArrayUtil.isSorted(randomArray));

        }
    }

    public static void sortHeap(int[] arr, int bound) {
        if (bound <= 1) return;
        int temp = arr[bound - 1];
        arr[bound - 1] = arr[0];
        arr[0] = temp;
        BuildHeap.heapify(arr, 0, bound - 1);
        sortHeap(arr, bound - 1);
    }

}
