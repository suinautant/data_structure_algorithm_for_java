package chap06;

// h값은 수열 40, 13, 4, 1
// 수열 규칙 3배수+1

public class ShellSort2 {
	public static void shellSort(int[] a, int n) {
		int h;
		for (h = 1; h < n / 9; h = h * 3 + 1)
			;

		for (; h > 0; h /= 3)
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
					a[j + h] = a[j];
				a[j + h] = tmp;
			}
	}

	public static void main(String[] args) {
		System.out.println("셸 정렬(버전 2)");
		int[] x = { 22, 5, 11, 32, 120, 68, 70 };
		int nx = x.length;

		for (int i = 0; i < nx; i++) {
			System.out.print("  " + x[i]);
		}
		System.out.println();

		shellSort(x, nx);

		System.out.println("오름차순으로 정렬");
		for (int i = 0; i < nx; i++) {
			System.out.print("  " + x[i]);
		}
		System.out.println();
	}

}
