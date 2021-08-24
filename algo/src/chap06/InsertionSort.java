package chap06;

import java.util.Scanner;

public class InsertionSort {
	static void printArr(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}

	static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int j;
			int tmp = a[i];
			int count = 1;
			for (j = i; j > 0 && a[j - 1] > tmp; j--) {
				a[j] = a[j - 1];
				System.out.println("  " + count++ + "번째");
				printArr(a);
			}
			a[j] = tmp;
			System.out.println("[ " + i + "단계 ]");
			printArr(a);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("단순 삽입 정렬");
//		System.out.print("요솟수 : ");
//		int nx = sc.nextInt();
//		int[] x = new int[nx];
//		int[] x = { 22, 5, 11, 32, 120, 68, 70 };
		int[] x = { 7, 6, 5, 4, 3, 2, 1 };
		int nx = x.length;

//		for (int i = 0; i < nx; i++) {
//			System.out.print("x[" + i + "] : ");
//			x[i] = sc.nextInt();
//		}

		System.out.println("정렬 전");
		printArr(x);
		System.out.println();
		insertionSort(x, nx);
		System.out.println();
		System.out.println("정렬 후");
		printArr(x);

//		System.out.println("오름차순으로 정렬했습니다.");
//		for (int i = 0; i < nx; i++) {
//			System.out.println("x[" + i + "] : " + x[i]);
//		}

	}
}
