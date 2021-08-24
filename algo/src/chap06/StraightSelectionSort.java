package chap06;

public class StraightSelectionSort {
	static void swap(int[] arr, int idx1, int idx2) {
		int t = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = t;
	}

	static void printArr(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}

	static void selectionSort(int[] arr) {
		int n = arr.length;
		printArr(arr);
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			swap(arr, i, min);
			printArr(arr);
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 4, 2, 3, 1 };
		System.out.println("=== Straight Selection Sort ===");
		selectionSort(arr);
	}
}
