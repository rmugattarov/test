package rmugattarov.y2019m12;

import rmugattarov.random.RandomUtil;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] randomArray = RandomUtil.getRandomArray();
        System.out.println(Arrays.toString(randomArray));
        mergeSort(randomArray);
        System.out.println(Arrays.toString(randomArray));
    }

    public static void mergeSort(int[] arr) {
        int[] aux = new int[arr.length];
        mergeSort(arr, aux, 0, aux.length);
    }

    private static void mergeSort(int[] arr, int[] aux, int from, int to) {
        if (to - from < 2) return;
        int mid = (from + to) / 2;
        mergeSort(arr, aux, from, mid);
        mergeSort(arr, aux, mid, to);
        merge(arr, aux, from, to);
    }

    private static void merge(int[] arr, int[] aux, int from, int to) {
        for (int i = from; i < to; i++) {
            aux[i] = arr[i];
        }
        int l = from;
        int mid = (from + to) / 2;
        int r = mid;
        int i = from;
        while (l < mid && r < to) {
            if (aux[l] < aux[r]) {
                arr[i] = aux[l++];
            } else {
                arr[i] = aux[r++];
            }
            i++;
        }
        while (l < mid) {
            arr[i++] = aux[l++];
        }
    }
}
