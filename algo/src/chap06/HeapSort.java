package chap06;

//@formatter:off
/**
 * 
 * 부모 (i-1)/2 
 * 왼쪽 자식 i*2+1 
 * 오른쪽 자식 i*2+2
 * 
 */
// @formatter:on
public class HeapSort {
	// 배열 요소의 값 교환
	static void swap(int[] a, int idx1, int idx2) {
		int tmp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = tmp;
	}

	// a[left] ~ a[right]를 힙으로 만든다
	static void downHeap(int[] a, int left, int right) {
		int temp = a[left]; // 루트
		int child; // 큰 값을 가진 노드
		int parent; // 부모

		for (parent = left; parent < (right + 1) / 2; parent = child) {
			int cl = parent * 2 + 1; // 왼쪽 자식
			int cr = cl + 1; // 오른쪽 자식
			child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // 큰 값을 가진 노드를 자식에 대입
			if (temp >= a[child])
				break;
			a[parent] = a[child];
		}
		a[parent] = temp;
	}

	static void heapSort(int[] a) {
		// 배열 a 길이
		int n = a.length;
		// 반복 : 중간값부터 첫번째 항목까지 역순
		// a[i] ~a[n-1]를 힙으로 만들기
		for (int i = (n - 1) / 2; i >= 0; i--)
			downHeap(a, i, n - 1);

		for (int i = n - 1; i > 0; i--) {
			swap(a, 0, i); // 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
			downHeap(a, 0, i - 1); // a[0]~a[i-1]을 힙으로 만든다.
		}
	}

	static void printArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		System.out.println("힙 정렬");
		int[] x = { 22, 5, 11, 32, 120, 68, 70 };
		printArr(x);
		heapSort(x);
		printArr(x);
	}
}
