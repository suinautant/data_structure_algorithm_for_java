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

	// �迭 ���� ���
	static void printSplit(int[] a, int left, int right) {
		System.out.print("a[" + left + "] ~ a[" + right + "] : {");
		for (int i = left; i < right; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[right] + "}");
	}

	// ��� �Լ��� �迭 ���� ���� ���� left�� right ���� �ʿ�
	static void quickSort(int[] a, int left, int right) {
		int pl = left; // ���� ������� pl
		int pr = right; // ���� �������� pr
		int x = a[(pl + pr) / 2]; // �ǹ� �� x

		printSplit(a, left, right);
		do {
			// ���� �ʿ� ���� ���� ��� (�ǹ� ������ ���� ���) pl ����
			// �ǹ� ���� ���� Ŭ ��� swap
			while (a[pl] < x)
				pl++;
			// ���� �ʿ� ���� ���� ��� (�ǹ� ������ ���� ���) p- ����
			// �ǹ� ���� ���� ���� ��� swap
			while (a[pr] > x)
				pr--;
			// pl�� pr�� ���� ���� ���� �ʾ����� pl�� pr�� �� swap
			if (pl <= pr)
				swap(a, pl++, pr--);
		} while (pl <= pr); // pl�� pr�� ���� �������� ���� ���� �ݺ�

		// ��ڼ��� ū �׷���� push()
		// ��ڼ��� ū �׷���� push() �ϸ� ���ÿ� ���ÿ� ����Ǵ� �ִ���� �� �ݴ��� ��쿡 ���� ����
		if ((pr - left + 1) <= (right - pl + 1)) {
			// left <----> pr pl <---> right
			// �迭 ���� ��� �Լ�
			if (left < pr)
				quickSort(a, left, pr);
			if (pl < right)
				quickSort(a, pl, right);
		} else {
			// left <----> pr pl <---> right
			// �迭 ���� ��� �Լ�
			if (pl < right)
				quickSort(a, pl, right);
			if (left < pr)
				quickSort(a, left, pr);
		}
	}

	public static void main(String[] args) {
		System.out.println("�� ����");
		int[] x = { 2, 1, 5, 8, 4, 2, 1, 2, 1, 2, 10, 20, 30, 6, 1, 3, 9, 7 };

		System.out.println("===== ���� �� =====");
		print(x);
		quickSort(x, 0, x.length - 1);
		System.out.println("===== ���� �� =====");
		print(x);

	}

}
