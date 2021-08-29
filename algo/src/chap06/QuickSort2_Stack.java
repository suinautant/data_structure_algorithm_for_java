package chap06;

public class QuickSort2_Stack {

	static void quickSort(int[] a, int left, int right) {
		// int stack class ���
		IntStack lstack = new IntStack(right - left + 1);
		IntStack rstack = new IntStack(right - left + 1);

		// pl(position left), pr(position right)�� lstack, rstack���� ���
		lstack.push(left);
		rstack.push(right);

		// lstack�� ������� �ʴٸ� while()
		while (lstack.isEmpty() != true) {
			// stack�� �׿� �ִ� ��ü ��� ���
			System.out.println();
			System.out.print("lstack dump : ");
			lstack.dump();
			System.out.print("rstack dump : ");
			rstack.dump();

			// stack�� ���� pl, pr�� pop()
			int pl = left = lstack.pop();
			int pr = right = rstack.pop();
			int x = a[(left + right) / 2];

			// ���ҵ� �迭 ���
			printSplit(a, left, right);
			// pr�� pl�� ���� ���� ���� �ʴ� �������� �ݺ�
			do {
				while (a[pl] < x)
					pl++;
				while (a[pr] > x)
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);

			// ��ڼ��� ū �׷���� push()
			// ��ڼ��� ū �׷���� push() �ϸ� ���ÿ� ���ÿ� ����Ǵ� �ִ���� �� �ݴ��� ��쿡 ���� ����
			if ((pr - left + 1) > (right - pl + 1)) {
				// �迭 �ɰ��� : lstack, rstack�� push()�� left, right ���� ����
				if (left < pr) {
					lstack.push(left);
					rstack.push(pr);
				}

				// �迭 �ɰ��� : lstack, rstack�� push()�� left, right ���� ����
				if (pl < right) {
					lstack.push(pl);
					rstack.push(right);
				}
			} else {
				// �迭 �ɰ��� : lstack, rstack�� push()�� left, right ���� ����
				if (pl < right) {
					lstack.push(pl);
					rstack.push(right);
				}
				// �迭 �ɰ��� : lstack, rstack�� push()�� left, right ���� ����
				if (left < pr) {
					lstack.push(left);
					rstack.push(pr);
				}				
			}

			/*
			 * // �迭 �ɰ��� : lstack, rstack�� push()�� left, right ���� ���� if (left < pr) {
			 * lstack.push(left); rstack.push(pr); }
			 * 
			 * // �迭 �ɰ��� : lstack, rstack�� push()�� left, right ���� ���� if (pl < right) {
			 * lstack.push(pl); rstack.push(right); }
			 */

		}
	}

	// �� ��ȯ
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// �迭 ���� ���
	static void printSplit(int[] a, int left, int right) {
		System.out.print("a[" + left + "] ~ a[" + right + "] : {");
		for (int i = left; i < right; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println(a[right] + "}");
	}

	// �迭 ���
	static void printArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] x = { 5, 8, 4, 2, 6, 1, 3, 9, 7 };

		System.out.println("===== �� ���� =====");
		System.out.println("\n\t[ ���� �� ]");
		printArr(x);
		System.out.println();
		quickSort(x, 0, x.length - 1);
		System.out.println();
		System.out.println("\n\t[ ���� �� ]");
		printArr(x);
	}
}
