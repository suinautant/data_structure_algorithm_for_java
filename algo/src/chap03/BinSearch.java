package chap03;

import java.util.Scanner;

public class BinSearch {
	private static int binSearch(int[] a, int key) {
		int n = a.length;
		int pl = 0;
		int pr = n - 1;

		do {
			int pc = (pl + pr) / 2;
			if (a[pc] == key)
				return pc;
			else if (a[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);

		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("��� ���� : ");
		int num = sc.nextInt();
		int[] x = new int[num];

		System.out.println("������������ �Է��ϼ���. ");

		System.out.print("x[0] : ");
		x[0] = sc.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] : ");
				x[i] = sc.nextInt();
			} while (x[i] < x[i - 1]);
		}

		System.out.println("�˻��� �� : ");
		int key = sc.nextInt();

		int idx = binSearch(x, key);

		if (idx == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(key + "�� x[" + idx + "]�� �ֽ��ϴ�.");
	}

}
