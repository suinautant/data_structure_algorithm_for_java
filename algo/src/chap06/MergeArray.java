package chap06;

public class MergeArray {
	static void printArr(int[] a, String nameArr) {

		System.out.println("�迭 : " + nameArr + " : ");
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

		// �迭 a�� b �� �ϳ��� �迭�� ������ ���� �ʾ��� ��� 
		// ���� ���� ������� �迭 c�� ����
		while (pa < na && pb < nb) {
			c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
		}

		// ���� a�迭�� ���� c�迭�� ����
		while (pa < na)
			c[pc++] = a[pa++];

		// ���� b�迭�� ���� c�迭�� ����
		while (pb < nb)
			c[pc++] = b[pb++];
	}

	public static void main(String[] args) {
		int[] a = { 2, 4, 6, 8, 11, 13 };
		int[] b = { 1, 2, 3, 4, 9, 16, 21 };
		int nc = a.length + b.length;
		int[] c = new int[nc];

		System.out.println("�� �迭�� ����");
		merge(a, b, c);

		System.out.println("�迭 a�� b�� �����Ͽ� �迭 c�� �����߽��ϴ�.");
		printArr(a, "a");
		printArr(b, "a");
		printArr(c, "a");

	}
}
