package chap03;

import java.util.Scanner;

public class SeqSearch {
	static int[] seqSearch(int[] a, int key) {
		int[] result = new int[a.length];
		result[0] = -1;
		int j = 0;

		for (int i = 0; i < a.length; i++) {
			System.out.print("   | ");
			for (int k = 0; k < i; k++) {
				System.out.print("  ");
			}
			System.out.print("*");
			System.out.println();

			System.out.print(" " + i + " |");
			for (int k = 0; k < a.length; k++) {
				System.out.print(" " + a[k]);
			}
			System.out.println();

			if (a[i] == key) {
				result[j++] = i;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("��ڼ� : ");
		int num = sc.nextInt();
		int[] x = new int[num];

		for (int i = 0; i < x.length; i++) {
			System.out.print(i + "��° �� : ");
			x[i] = sc.nextInt();
		}

		System.out.print("�˻� �� �� : ");
		int key = sc.nextInt();

		System.out.print("   |");
		for (int i = 0; i < x.length; i++) {
			System.out.print(" " + i);
		}
		System.out.println();
		System.out.println("---+-------------------------------");

		int[] idx = seqSearch(x, key);

		System.out.println();
		if (idx[0] == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else {
			for (int i = 0; i < idx.length; i++) {
				if (idx[i] != 0)
					System.out.println(key + "�� " + idx[i] + "��°�� �ֽ��ϴ�.");
			}
		}
	}
}
