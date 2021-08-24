package chap06;

import java.util.Iterator;
import java.util.Scanner;

// 알고리즘 개선 2
// exchg 이용해 더 이상 정렬 필요 없는 단계에서 종료

// 알고리즘 개선 3
// 정렬 필요 없는 배열 인덱스 생략

public class BubbleSort_ex2_3 {
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
		System.out.println("오름차순으로 정렬했습니다.");
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
		countComp = 0;
		countExchange = 0;

		for (int i = 0; i < n - 1; i++) {
			int exchg = 0;
			int last = 0;

			System.out.println();
			System.out.println("패스 " + (i + 1) + ":");
			// 정렬
			for (int j = n - 1; j > i; j--) {
				countComp++;
				// 오름차순과 내림차순 결정 조건
				// 교환 예정 대상은 "+", 미교환 예정 대상은 "-"로 관계 표시
				if (a[j] < a[j - 1]) {
					countExchange++;
					exchg++;
					last = j - 1;
//					System.out.println("마지막 위치 : " + last);
					printWBlank(a, TAB_PLUS, j);
					swap(a, j, j - 1);
				} else
					printWBlank(a, TAB_MINUS, j);
			}
			if (exchg == 0)
				break;
			printWBlank(a, TAB_BLANK, 0);
			if (last != 0) {
				i = last;
//				System.out.println("위치 변경 i = " + last);
			}
		}
	}

	static void bubbleSortV3(int[] a) {
		int n = a.length;
		int k = 0;
		int count = 1;
		countComp = 0;
		countExchange = 0;

		while (k < n - 1) {
			int exchg = 0;
			System.out.println();
			System.out.println("패스 " + count++ + ":");
			int last = n - 1;
			for (int j = n - 1; j > k; j--) {
				countComp++;
				if (a[j - 1] > a[j]) {
					countExchange++;
					exchg++;
					printWBlank(a, TAB_PLUS, j);
					swap(a, j - 1, j);
					last = j;
				} else
					printWBlank(a, TAB_MINUS, j);

			}
			if (exchg == 0)
				break;
			k = last;
		}
	}

	public static void main(String[] args) {
		countComp = 0;
		countExchange = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("버블 정렬(버전1 - 연습문제)");
		/*
		 * System.out.print("요솟수 : "); int xn = sc.nextInt(); int[] x = new int[xn];
		 * 
		 * for (int i = 0; i < xn; i++) { System.out.print("x[" + i + "] : "); x[i] =
		 * sc.nextInt(); }
		 */
		int xn = 7;
//		int[] x = { 22, 5, 11, 32, 120, 68, 70 };
		// 알고리즘 개선 3 확인위해 배열 값 수정
		int[] x = { 22, 5, 10, 32, 120, 68, 70 };
		int[] y = { 22, 5, 10, 32, 120, 68, 70 };

		System.out.println("==== 버블 정렬 버전2 =====");
		bubbleSort(x);
		System.out.println();
		System.out.println("비교를 " + countComp + "회 했습니다.");
		System.out.println("교환을 " + countExchange + "회 했습니다.");

		System.out.println("==== 버블 정렬 버전3 =====");
		bubbleSortV3(y);
		System.out.println();
		System.out.println("비교를 " + countComp + "회 했습니다.");
		System.out.println("교환을 " + countExchange + "회 했습니다.");

	}
}
