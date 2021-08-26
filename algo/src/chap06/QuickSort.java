package chap06;

public class QuickSort {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	// 배열 범위 출력
	static void printSplit(int[] a, int left, int right) {
		System.out.print("a[" + left + "] ~ a[" + right + "] : {");
		for (int i = left; i < right; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[right] + "}");
	}

	// 재귀 함수로 배열 분할 정렬 위해 left와 right 변수 필요
	static void quickSort(int[] a, int left, int right) {
		int pl = left; // 정렬 출발지를 pl
		int pr = right; // 정렬 종착지를 pr
		int x = a[(pl + pr) / 2]; // 피벗 값 x

		printSplit(a, left, right);
		do {
			// 정렬 필요 하지 않은 경우 (피벗 값보다 작을 경우) pl 전진
			// 피벗 보다 값이 클 경우 swap
			while (a[pl] < x)
				pl++;
			// 정렬 필요 하지 않은 경우 (피벗 값보다 작을 경우) p- 후진
			// 피벗 보다 값이 작을 경우 swap
			while (a[pr] > x)
				pr--;
			// pl과 pr이 서로 교차 되지 않았으면 pl과 pr의 값 swap
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr); // pl과 pr이 서로 교차하지 않을 동안 반복

		// 요솟수가 큰 그룹부터 push()
		// 요솟수가 큰 그룹부터 push() 하면 스택에 스택에 저장되는 최대수가 그 반대의 경우에 비해 감소
		if ((pr - left + 1) <= (right - pl + 1)) {
			// left <----> pr pl <---> right
			// 배열 분할 재귀 함수
			if (left < pr)
				quickSort(a, left, pr);
			if (pl < right)
				quickSort(a, pl, right);
		} else {
			// left <----> pr pl <---> right
			// 배열 분할 재귀 함수
			if (pl < right)
				quickSort(a, pl, right);
			if (left < pr)
				quickSort(a, left, pr);
		}
	}

	public static void main(String[] args) {
		System.out.println("퀵 정렬");
		int[] x = { 2, 1, 5, 8, 4, 2, 1, 2, 1, 2, 10, 20, 30, 6, 1, 3, 9, 7 };

		System.out.println("===== 정렬 전 =====");
		print(x);
		quickSort(x, 0, x.length - 1);
		System.out.println("===== 정렬 후 =====");
		print(x);

	}

}
