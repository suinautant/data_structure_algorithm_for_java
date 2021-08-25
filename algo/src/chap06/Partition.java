package chap06;

public class Partition {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void partition(int[] a) {
		int n = a.length;
		int pl = 0;
		int pr = n - 1;
		int x = a[n / 2];

		do {
			while (a[pl] < x)
				pl++;
			while (a[pr] > x)
				pr--;
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr);

		System.out.println("�ǹ��� ���� " + x + "�Դϴ�.");

		System.out.println("�ǹ� ������ �׷�");
		for (int i = 0; i <= pl - 1; i++)
			System.out.print(a[i] + " ");
		System.out.println();

		if (pl > pr + 1) {
			System.out.println("�ǹ��� ��ġ�ϴ� �׷�");
			for (int i = pr + 1; i <= pl - 1; i++)
				System.out.print(a[i] + " ");
			System.out.println();
		}

		System.out.println("�ǹ� �̻��� �׷�");
		for (int i = pr + 1; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("�迭�� �����ϴ�.");
		int[] x = { 5, 8, 6, 2, 6, 1, 3, 9, 7 };

		System.out.println("�迭 ���� ����");
		print(x);
		partition(x);
		System.out.println("�迭 ���� ����");
		print(x);
	}
}
