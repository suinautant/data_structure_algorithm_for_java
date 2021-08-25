package chap06;

public class ShellSort {
	public static void shellSort(int[] a, int n) {
		for (int h = n / 2; h > 0; h /= 2)
			for (int i = h; i < n; i++) {
				int j;
				int tmp = a[i];
				for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
					a[j + h] = a[j];
				a[j + h] = tmp;
			}
	}

	public static void main(String[] args) {
		System.out.println("셸 정렬(버전 1)");
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
