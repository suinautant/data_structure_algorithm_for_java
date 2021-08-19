package chap02;

import java.util.Scanner;

public class ArrayEqual {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static boolean equals(int[] a, int[] b) {
		if (a.length != b.length)
			return false;

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	static int[] inputArray() {
		Scanner sc = new Scanner(System.in);

		System.out.println("��� �� �Է� : ");
		int num = sc.nextInt();
		int[] a = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("a[" + i + " ] : ");
			a[i] = sc.nextInt();
		}
		System.out.println();
		return a;
	}

	static void printArray(int[] a, String arrayName) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(arrayName + "[" + i + "] : " + a[i]);
		}
		System.out.println();
	}

	static void copy(int[] a, int[] b) {
		for (int i = 0; i < b.length; i++) {
			a[i] = b[i];
		}
	}

	static void rcopy(int[] a, int[] b) {
		int[] c = new int[3];
		copy(c, b);
		for (int i = 0; i < c.length / 2; i++) {
			swap(c, i, c.length - 1 - i);
		}
		for (int i = 0; i < c.length; i++) {
			a[i] = c[i];

		}
	}

	public static void main(String[] args) {
		int[] a = inputArray();
		int[] b = inputArray();

		System.out.println("�迭 ����");
		copy(a, b);
		printArray(a, "a");
		printArray(b, "b");

		System.out.println("�迭 ���� ����");
		rcopy(a, b);
		printArray(a, "a");
		printArray(b, "b");

//
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("��� �� �Է� : ");
//		int num = sc.nextInt();
//		int[] a = new int[num];
//
//		for (int i = 0; i < num; i++) {
//			System.out.print("a[" + i + " ] : ");
//			a[i] = sc.nextInt();
//		}
//		System.out.println();
//
//		System.out.println("��� �� �Է� : ");
//		num = sc.nextInt();
//		int[] b = new int[num];
//		for (int i = 0; i < num; i++) {
//			System.out.print("b[" + i + " ] : ");
//			b[i] = sc.nextInt();
//		}
//		System.out.println();
//

//		// �迭 �Է� �Լ�ȭ
//		int[] a = inputArray();
//		int[] b = inputArray();
//
//		System.out.println("1> �迭 a�� b�� " + (equals(a, b) ? "����." : "���� �ʴ�."));
//
//		String result = "";
//		if (equals(a, b)) {
//			result = "����.";
//		} else {
//			result = "���� �ʴ�.";
//		}
//		System.out.println("2> �迭 a�� b�� " + result);
	}

}
