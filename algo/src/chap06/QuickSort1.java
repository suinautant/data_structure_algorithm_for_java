package chap06;

public class QuickSort1 {
	static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int pivot = a[(pl + pr) / 2];

		printArrRange(a, left, right);

		do {
			while (a[pl] < pivot)
				pl++;
			while (a[pr] > pivot)
				pr--;
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);

		if (left < pr)
			quickSort(a, left, pr);
		if (pl < right)
			quickSort(a, pl, right);
	}

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void printArrRange(int[] a, int left, int right) {
		System.out.print("a[" + left + "] ~ a[" + right + "] : {");
		for (int i = left; i < right; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[right] + "}");
	}

	// 한 칸 띄우며 가로로 출력, 모두 출력 후 한 행 공백
	static void printArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		int[] x = { 5, 8, 4, 2, 6, 1, 3, 9, 7 };
		System.out.println("===== 퀵 정렬 =====");
		System.out.println("\n\t[ 정렬 전 ]");
		printArr(x);
		quickSort(x, 0, x.length - 1);
		System.out.println("\n\t[ 정렬 후 ]");
		printArr(x);
	}
}
