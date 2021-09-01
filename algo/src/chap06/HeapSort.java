package chap06;

//@formatter:off
/**
 * 
 * �θ� (i-1)/2 
 * ���� �ڽ� i*2+1 
 * ������ �ڽ� i*2+2
 * 
 */
// @formatter:on
public class HeapSort {
	// �迭 ����� �� ��ȯ
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}

	// a[left] ~ a[right]�� ������ �����
	static void downHeap(int[] a, int left, int right) {
		int temp = a[left]; // ��Ʈ
		int child; // ū ���� ���� ���
		int parent; // �θ�

		for (parent = left; parent < (right + 1) / 2; parent = child) {
			int cl = parent * 2 + 1; // ���� �ڽ�
			int cr = cl + 1; // ������ �ڽ�
			child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // ū ���� ���� ��带 �ڽĿ� ����
			if (temp >= a[child])
				break;
			a[parent] = a[child];
		}
		a[parent] = temp;
	}

	static void heapSort(int[] a) {
		// �迭 a ����
		int n = a.length;
		// �ݺ� : �߰������� ù��° �׸���� ����
		// a[i] ~a[n-1]�� ������ �����
		for (int i = (n - 1) / 2; i >= 0; i--)
			downHeap(a, i, n - 1);

		for (int i = n - 1; i > 0; i--) {
			swap(a, 0, i); // ���� ū ��ҿ� ���� ���ĵ��� ���� �κ��� ������ ��Ҹ� ��ȯ
			downHeap(a, 0, i - 1); // a[0]~a[i-1]�� ������ �����.
		}
	}

	static void printArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("�� ����");
		int[] x = { 22, 5, 11, 32, 120, 68, 70 };
		printArr(x);
		heapSort(x);
		printArr(x);
	}
}
