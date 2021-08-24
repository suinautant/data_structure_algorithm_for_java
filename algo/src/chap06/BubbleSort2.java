package chap06;

import java.util.Scanner;

public class BubbleSort2 {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void bubbleSort(int[] a, int n) {
		for (int i = 0; i < n - 1; i++) {
			int exchg = 0;
			for (int j = n - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
					exchg++;
				}
			}
			if (exchg == 0)
				break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("버블 정렬(버전 1)");
		/*
		 * System.out.print("요솟수 : "); int xn = sc.nextInt(); int[] x = new int[xn];
		 * 
		 * for (int i = 0; i < xn; i++) { System.out.print("x[" + i + "] : "); x[i] =
		 * sc.nextInt(); }
		 */
		int nx = 7;
		int[] x = { 22, 5, 11, 32, 120, 68, 70 };

		bubbleSort(x, nx);

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}

	}
}
