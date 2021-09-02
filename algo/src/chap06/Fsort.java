package chap06;

public class Fsort {
	static void fSort(int[] a, int n, int max) {
		int[] f = new int[max + 1];
		int[] b = new int[n];

		for (int i = 0; i < n; i++)
			f[a[i]]++;
		for (int i = 1; i <= max; i++)
			f[i] += f[i - 1];
		for (int i = n - 1; i >= 0; i--)
			b[--f[a[i]]] = a[i];
		for (int i = 0; i < n; i++)
			a[i] = b[i];
	}

	static void printArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("도수 정렬");
		int[] x = { 22, 5, 11, 32, 120, 68, 70 };
		int nx = x.length;

		printArr(x);
		int max = x[0];
		for (int i = 1; i < nx; i++) {
			if (x[i] > max)
				max = x[i];
		}
		fSort(x, nx, max);
		printArr(x);
	}
}
