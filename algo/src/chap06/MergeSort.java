package chap06;

public class MergeSort {
	static int buff[];

	// �迭 ����
	static void __mergeSort(int[] a, int left, int right) {
		// �迭 ��Ұ� 2���� ������ �迭�� ������
		if (left < right) {
			int i; // �ݺ��� �ε����� �ӽ� ����
			int center = ((left + right) / 2); // �迭�� �߾� �ε���
			int p = 0; // buff �迭�� Ŀ�� (a -> buff �����, ���� ������ length)
			int j = 0; // buff �迭�� Ŀ�� (buff -> a �����)
			int k = left; // �迭�� ���� �ε���

			// �迭 �պκ� ���� ����
			__mergeSort(a, left, center);
			// �迭 �޺κ� ���� ����
			__mergeSort(a, center + 1, right);

			// �迭�� �պκ� (n/2) �ӽ� �迭�� ����
			System.out.println("[ �迭 -> �ӽ� �迭 ���� ]");
			for (i = left; i <= center; i++) {
				System.out.println("\tbuff[" + p + "++] = " + a[i]);
				buff[p++] = a[i];
			}

			// �迭�� �պκ� (�ӽ� �迭)�� �� �κ��� ���ؼ� ���� ���� �迭�� ���������� ���� ����
			System.out.println("[ �ӽ� �迭(��)�� �迭 �ܿ�(��) �� �� ���� ���� ]");
			while (i <= right && j < p) {
				System.out.println(
						"\ta[" + k + "++] = (buff[" + j + "] <= a[" + i + "]) ? buff[" + j + "++] : a[" + i + "++]");
				System.out.println("\t" + a[k] + " = (" + buff[j] + " <= " + a[i] + ") ? " + buff[j] + " : " + a[i]);
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
			}

			// �ӽ� �迭�� ���� ���Ҵٸ�, ������ a�迭�� ����
			while (j < p)
				a[k++] = buff[j++];

		}
	}

	// �迭 ���
	static void print(int[] a) {
		System.out.print("array[] : {");
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println(" }");
	}

	// �迭 ���� ����
	static void mergeSort(int[] a) {
		int na = a.length;
		buff = new int[na];
		// ���� ����
		__mergeSort(a, 0, na - 1);
		buff = null;
	}

	public static void main(String[] args) {
		System.out.println("���� ����");
		int[] x = { 22, 5, 11, 32, 120, 68, 70 };
		// ���� �� �迭 ���
		print(x);
		// x�迭 ���� ����
		mergeSort(x);
		System.out.println("������������ �����߽��ϴ�.");
		// ���� �� �迭 ���
		print(x);
	}

}
