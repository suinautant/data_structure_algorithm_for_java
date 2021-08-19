package chap02;

import java.util.Random;
import java.util.Scanner;

public class ReverseArray {
	// �������� ��� �� �Է�
	// �������� �� ��ҿ� �����ϴ� int �� �Է�
	// �迭�� �������� ����

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
		System.out.println("��� �� : " + num);

		int[] arrayNum = new int[num];
		for (int i = 0; i < num; i++) {
			arrayNum[i] = rand.nextInt(10);
			System.out.print(arrayNum[i] + " ");
		}
		System.out.println();

		reverse(arrayNum);
		System.out.println("��Ҹ� �������� �����߽��ϴ�.");

		for (int i = 0; i < arrayNum.length; i++) {
			System.out.print(arrayNum[i] + " ");
		}
		System.out.println();
	}

}
