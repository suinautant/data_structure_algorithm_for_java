package chap06;

import java.util.Iterator;
import java.util.Scanner;

public class BubbleSort_ex2 {
	static String TAB_BLANK = "   ";
	static String TAB_PLUS = " + ";
	static String TAB_MINUS = " - ";
	static int countComp;
	static int countExchange;

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void printArray(int[] a) {
		System.out.println("������������ �����߽��ϴ�.");
		for (int i = 0; i < a.length; i++) {
			System.out.println("x[" + i + "] = " + a[i]);
		}

	}


	static void printWBlank(int[] a, String s, int count) {
		// print
		for (int i = 0; i < a.length; i++) {
			String tab = TAB_BLANK;
			if (i == count) {
				tab = s;
			}
			System.out.print(tab + a[i]);
		}
		System.out.println();
	}

	static void bubbleSort(int[] a) {
		int n = a.length;

		for (int i = 0; i < n - 1; i++) {
			int exchg = 0;
			System.out.println();
			System.out.println("�н� " + (i + 1) + ":");

			// ����
			String tab;
			for (int j = n - 1; j > i; j--) {
				countComp++;
				// ���������� �������� ���� ����
				// ��ȯ ���� ����� "+", �̱�ȯ ���� ����� "-"�� ���� ǥ��
				if (a[j] < a[j - 1]) {
					countExchange++;
					exchg++;
					printWBlank(a, TAB_PLUS, j);
					swap(a, j, j - 1);
				} else
					printWBlank(a, TAB_MINUS, j);
			}
			if (exchg ==0) break;
					printWBlank(a, TAB_BLANK, 0);
		}
	}

	public static void main(String[] args) {
		countComp = 0;
		countExchange = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("���� ����(����1 - ��������)");
		/*
		 * System.out.print("��ڼ� : "); int xn = sc.nextInt(); int[] x = new int[xn];
		 * 
		 * for (int i = 0; i < xn; i++) { System.out.print("x[" + i + "] : "); x[i] =
		 * sc.nextInt(); }
		 */
		int xn = 7;
		int[] x = { 22, 5, 11, 32, 120, 68, 70 };

		bubbleSort(x);

		System.out.println();
		System.out.println("�񱳸� " + countComp + "ȸ �߽��ϴ�.");
		System.out.println("��ȯ�� " + countExchange + "ȸ �߽��ϴ�.");

	}
}
