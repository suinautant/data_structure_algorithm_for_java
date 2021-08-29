package chap06;

public class QuickSort2_Stack {

	static void quickSort(int[] a, int left, int right) {
		// int stack class 사용
		IntStack lstack = new IntStack(right - left + 1);
		IntStack rstack = new IntStack(right - left + 1);

		// pl(position left), pr(position right)를 lstack, rstack으로 사용
		lstack.push(left);
		rstack.push(right);

		// lstack이 비어있지 않다면 while()
		while (lstack.isEmpty() != true) {
			// stack에 쌓여 있는 전체 목록 출력
			System.out.println();
			System.out.print("lstack dump : ");
			lstack.dump();
			System.out.print("rstack dump : ");
			rstack.dump();

			// stack의 값의 pl, pr로 pop()
			int pl = left = lstack.pop();
			int pr = right = rstack.pop();
			int x = a[(left + right) / 2];

			// 분할된 배열 출력
			printSplit(a, left, right);
			// pr과 pl이 서로 교차 되지 않는 범위까지 반복
			do {
				while (a[pl] < x)
					pl++;
				while (a[pr] > x)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);

			// 요솟수가 큰 그룹부터 push()
			// 요솟수가 큰 그룹부터 push() 하면 스택에 스택에 저장되는 최대수가 그 반대의 경우에 비해 감소
			if ((pr - left + 1) > (right - pl + 1)) {
				// 배열 쪼개기 : lstack, rstack에 push()로 left, right 설정 가능
				if (left < pr) {
					lstack.push(left);
					rstack.push(pr);
				}

				// 배열 쪼개기 : lstack, rstack에 push()로 left, right 설정 가능
				if (pl < right) {
					lstack.push(pl);
					rstack.push(right);
				}
			} else {
				// 배열 쪼개기 : lstack, rstack에 push()로 left, right 설정 가능
				if (pl < right) {
					lstack.push(pl);
					rstack.push(right);
				}
				// 배열 쪼개기 : lstack, rstack에 push()로 left, right 설정 가능
				if (left < pr) {
					lstack.push(left);
					rstack.push(pr);
				}				
			}

			/*
			 * // 배열 쪼개기 : lstack, rstack에 push()로 left, right 설정 가능 if (left < pr) {
			 * lstack.push(left); rstack.push(pr); }
			 * 
			 * // 배열 쪼개기 : lstack, rstack에 push()로 left, right 설정 가능 if (pl < right) {
			 * lstack.push(pl); rstack.push(right); }
			 */

		}
	}

	// 값 교환
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// 배열 범위 출력
	static void printSplit(int[] a, int left, int right) {
		System.out.print("a[" + left + "] ~ a[" + right + "] : {");
		for (int i = left; i < right; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[right] + "}");
	}

	// 배열 출력
	static void printArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] x = { 5, 8, 4, 2, 6, 1, 3, 9, 7 };

		System.out.println("===== 퀵 정렬 =====");
		System.out.println("\n\t[ 정렬 전 ]");
		printArr(x);
		System.out.println();
		quickSort(x, 0, x.length - 1);
		System.out.println();
		System.out.println("\n\t[ 정렬 후 ]");
		printArr(x);
	}
}
