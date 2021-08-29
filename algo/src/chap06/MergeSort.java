package chap06;

public class MergeSort {
	static int buff[];

	// 배열 정렬
	static void __mergeSort(int[] a, int left, int right) {
		// 배열 요소가 2개일 때까지 배열을 나누기
		if (left < right) {
			int i; // 반복분 인덱스용 임시 변수
			int center = ((left + right) / 2); // 배열의 중앙 인덱스
			int p = 0; // buff 배열의 커서 (a -> buff 복사시, 복사 종료후 length)
			int j = 0; // buff 배열의 커서 (buff -> a 복사시)
			int k = left; // 배열의 시작 인덱스

			// 배열 앞부분 병합 정렬
			__mergeSort(a, left, center);
			// 배열 뒷부분 병합 정렬
			__mergeSort(a, center + 1, right);

			// 배열의 앞부분 (n/2) 임시 배열로 복사
			System.out.println("[ 배열 -> 임시 배열 복사 ]");
			for (i = left; i <= center; i++) {
				System.out.println("\tbuff[" + p + "++] = " + a[i]);
				buff[p++] = a[i];
			}

			// 배열의 앞부분 (임시 배열)과 뒷 부분을 비교해서 작은 값을 배열에 순차적으로 정렬 저장
			System.out.println("[ 임시 배열(앞)과 배열 잔여(뒤) 비교 후 정렬 저장 ]");
			while (i <= right && j < p) {
				System.out.println(
						"\ta[" + k + "++] = (buff[" + j + "] <= a[" + i + "]) ? buff[" + j + "++] : a[" + i + "++]");
				System.out.println("\t" + a[k] + " = (" + buff[j] + " <= " + a[i] + ") ? " + buff[j] + " : " + a[i]);
				a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
			}

			// 임시 배열의 값이 남았다면, 나머지 a배열에 복사
			while (j < p)
				a[k++] = buff[j++];

		}
	}

	// 배열 출력
	static void print(int[] a) {
		System.out.print("array[] : {");
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println(" }");
	}

	// 배열 병합 정렬
	static void mergeSort(int[] a) {
		int na = a.length;
		buff = new int[na];
		// 병합 정렬
		__mergeSort(a, 0, na - 1);
		buff = null;
	}

	public static void main(String[] args) {
		System.out.println("병렬 정렬");
		int[] x = { 22, 5, 11, 32, 120, 68, 70 };
		// 정렬 전 배열 출력
		print(x);
		// x배열 병합 정렬
		mergeSort(x);
		System.out.println("오름차순으로 정렬했습니다.");
		// 정렬 전 배열 출력
		print(x);
	}

}
