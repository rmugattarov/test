package rmugattarov.heap;

import rmugattarov.random.RandomUtil;

import java.util.Arrays;

public class BuildHeap {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] randomArray = RandomUtil.getRandomArray();
            System.out.println(Arrays.toString(randomArray));
            System.out.println(isMaxHeap(randomArray));
            buildHeap(randomArray);
            System.out.println(Arrays.toString(randomArray));
            System.out.println(isMaxHeap(randomArray));
        }
    }

    public static void buildHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    public static void heapify(int[] arr, int i, int bound) {
        int leftChildIndex = i * 2 + 1;
        int rightChildIndex = i * 2 + 2;
        int greatestChildIndex = i;
        if (leftChildIndex < bound && arr[leftChildIndex] > arr[greatestChildIndex]) {
            greatestChildIndex = leftChildIndex;
        }
        if (rightChildIndex < bound && arr[rightChildIndex] > arr[greatestChildIndex]) {
            greatestChildIndex = rightChildIndex;
        }
        if (greatestChildIndex != i) {
            int temp = arr[i];
            arr[i] = arr[greatestChildIndex];
            arr[greatestChildIndex] = temp;
            heapify(arr, greatestChildIndex, bound);
        }
    }

    public static boolean isMaxHeap(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int leftChildIndex = i * 2 + 1;
            int rightChildIndex = i * 2 + 2;
            if (leftChildIndex < arr.length && arr[leftChildIndex] > arr[i]) return false;
            if (rightChildIndex < arr.length && arr[rightChildIndex] > arr[i]) return false;
        }
        return true;
    }
}
