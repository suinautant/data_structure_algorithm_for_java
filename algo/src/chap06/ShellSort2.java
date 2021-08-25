package chap06;

// h���� ���� 40, 13, 4, 1
// ���� ��Ģ 3���+1

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
		System.out.println("�� ����(���� 2)");
		int[] x = { 22, 5, 11, 32, 120, 68, 70 };
		int nx = x.length;

		for (int i = 0; i < nx; i++) {
			System.out.print("  " + x[i]);
		}
		System.out.println();

		shellSort(x, nx);

		System.out.println("������������ ����");
		for (int i = 0; i < nx; i++) {
			System.out.print("  " + x[i]);
		}
		System.out.println();
	}

}
