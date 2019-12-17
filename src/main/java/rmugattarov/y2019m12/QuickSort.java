package rmugattarov.y2019m12;

import rmugattarov.random.RandomUtil;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] randomArray = RandomUtil.getRandomArray();
        System.out.println(Arrays.toString(randomArray));
        quickSort(randomArray, 0, randomArray.length - 1);
        System.out.println(Arrays.toString(randomArray));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
