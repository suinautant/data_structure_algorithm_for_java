package chap06;

public class MergeArray {
	static void printArr(int[] a, String nameArr) {

		System.out.println("배열 : " + nameArr + " : ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	static void merge(int[] a, int[] b, int[] c) {
		// length array
		int na = a.length;
		int nb = b.length;
		// position array
		int pa = 0;
		int pb = 0;
		int pc = 0;

		// 배열 a와 b 중 하나라도 배열의 끝까지 가지 않았을 경우 
		// 작은 값을 순서대로 배열 c에 저장
		while (pa < na && pb < nb) {
			c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
		}

		// 남은 a배열의 값을 c배열에 저장
		while (pa < na)
			c[pc++] = a[pa++];

		// 남은 b배열의 값을 c배열에 저장
		while (pb < nb)
			c[pc++] = b[pb++];
	}

	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8, 11, 13 };
		int[] b = { 1, 2, 3, 4, 9, 16, 21 };
		int nc = a.length + b.length;
		int[] c = new int[nc];

		System.out.println("두 배열의 병합");
		merge(a, b, c);

		System.out.println("배열 a와 b를 병합하여 배열 c에 저장했습니다.");
		printArr(a, "a");
		printArr(b, "a");
		printArr(c, "a");

	}
}
