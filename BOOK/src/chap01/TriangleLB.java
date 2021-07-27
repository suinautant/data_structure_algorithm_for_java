package chap01;

import java.util.Scanner;

public class TriangleLB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;

		System.out.println("�̵ �ﰢ���� ����մϴ�.");

		do {
			System.out.print("�� �� �ﰢ���Դϱ� ? : ");
			n = sc.nextInt();
		} while (n <= 0);

//		triangleLB(n);
//		triangleLU(n);
		triangleRU(n);
	}

	// ������ ���� ������ �̵ �ﰢ�� ���
	static void triangleRU(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// ���� ���� ������ �̵ �ﰢ�� ���
	static void triangleLU(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = i; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// ���� �Ʒ��� ������ �̵ �ﰢ�� ���
	static void triangleLB(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
