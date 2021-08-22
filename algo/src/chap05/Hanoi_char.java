package chap05;

import java.util.Scanner;

public class Hanoi_char {
	static void move(int no, int x, int y) {
		char[] pillar = { 'A', 'B', 'C' };
		if (no > 1)
			move(no - 1, x, 6 - x - y);
		// ���� �迭�� �ε��� �� �����ϰ� �ϱ� ���� x�� y�� ���� 1�� ����
		System.out.println("����[" + no + "]�� " + pillar[x - 1] + "��տ��� " + pillar[y - 1] + "������� �ű�");
		if (no > 1)
			move(no - 1, 6 - x - y, y);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ϳ����� ž");
		System.out.print("���� ���� : ");
		int n = sc.nextInt();

		move(n, 1, 3);
	}
}
