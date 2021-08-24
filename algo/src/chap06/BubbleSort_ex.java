package chap06;

import java.util.Iterator;
import java.util.Scanner;

public class BubbleSort_ex {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void bubbleSort(int[] a) {
		int n = a.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1])
					swap(a, j, j + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("���� ����(����1 - ��������)");
		System.out.print("��ڼ� : ");
		int xn = sc.nextInt();
		int[] x = new int[xn];

		for (int i = 0; i < xn; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}

		bubbleSort(x);

		System.out.println("������������ �����߽��ϴ�.");
		for (int i = 0; i < xn; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}
	}
}
