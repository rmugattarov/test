package rmugattarov.basics.y2018m10;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class InsertSort {
	private static final Random R = ThreadLocalRandom.current();
	
	public static void main(String[] args) {
		int[] arr = getRandomArray();
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void sort(int[] arr) {
		if (arr.length < 2) return;
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i]) {
					int temp = arr[i];
					shift(arr, j + 1, i - j - 1);
					arr[j + 1] = temp;
					break;
				} else if (j == 0) {
					int temp = arr[i];
					shift(arr, 0, i - j);
					arr[0] = temp;
					break;
				}
			}
		}
	}
	
	private static void shift(int[] arr, int start, int length) {
		while(length > 0) {
			int i = start + length--;
			arr[i] = arr[i - 1];
		}
	}
	
	private static int[] getRandomArray() {
		int l = R.nextInt(10);
		int[] result = new int[l];
		for(int i=0; i<l; i++) {
			result[i] = R.nextInt(10);
		}
		return result;
	}
}