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

		System.out.println("요소 수 입력 : ");
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

		System.out.println("배열 복사");
		copy(a, b);
		printArray(a, "a");
		printArray(b, "b");

		System.out.println("배열 역순 복사");
		rcopy(a, b);
		printArray(a, "a");
		printArray(b, "b");

//
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("요소 수 입력 : ");
//		int num = sc.nextInt();
//		int[] a = new int[num];
//
//		for (int i = 0; i < num; i++) {
//			System.out.print("a[" + i + " ] : ");
//			a[i] = sc.nextInt();
//		}
//		System.out.println();
//
//		System.out.println("요소 수 입력 : ");
//		num = sc.nextInt();
//		int[] b = new int[num];
//		for (int i = 0; i < num; i++) {
//			System.out.print("b[" + i + " ] : ");
//			b[i] = sc.nextInt();
//		}
//		System.out.println();
//

//		// 배열 입력 함수화
//		int[] a = inputArray();
//		int[] b = inputArray();
//
//		System.out.println("1> 배열 a와 b는 " + (equals(a, b) ? "같다." : "같지 않다."));
//
//		String result = "";
//		if (equals(a, b)) {
//			result = "같다.";
//		} else {
//			result = "같지 않다.";
//		}
//		System.out.println("2> 배열 a와 b는 " + result);
	}

}
