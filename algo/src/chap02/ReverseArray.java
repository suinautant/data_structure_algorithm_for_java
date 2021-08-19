package chap02;

import java.util.Random;
import java.util.Scanner;

public class ReverseArray {
	// 랜덤으로 요수 수 입력
	// 랜덤으료 각 요소에 대응하는 int 값 입력
	// 배열을 역순으로 정렬

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;

	}

	static void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			swap(a, i, a.length - 1 - i);

			System.out.println((int) (i + 1) + " / " + (int) (a.length / 2 + 1));
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int num = rand.nextInt(10) + 1;
		System.out.println("요소 수 : " + num);

		int[] arrayNum = new int[num];
		for (int i = 0; i < num; i++) {
			arrayNum[i] = rand.nextInt(10);
			System.out.print(arrayNum[i] + " ");
		}
		System.out.println();

		reverse(arrayNum);
		System.out.println("요소를 역순으로 정렬했습니다.");

		for (int i = 0; i < arrayNum.length; i++) {
			System.out.print(arrayNum[i] + " ");
		}
		System.out.println();
	}

}
