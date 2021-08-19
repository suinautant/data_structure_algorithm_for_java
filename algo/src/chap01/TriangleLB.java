package chap01;

import java.util.Scanner;

public class TriangleLB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;

		System.out.println("이등변 삼각형을 출력합니다.");

		do {
			System.out.print("몇 단 삼각형입니까 ? : ");
			n = sc.nextInt();
		} while (n <= 0);

//		triangleLB(n);
//		triangleLU(n);
//		triangleRU(n);
		triangleRB(n);
	}

	// 오른쪽 아래가 직각인 이등변 삼각형 출력
	static void triangleRB(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= 1; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// 오른쪽 위가 직각인 이등변 삼각형 출력
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

	// 왼쪽 위가 직각인 이등변 삼각형 출력
	static void triangleLU(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = i; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// 왼쪽 아래가 직각인 이등변 삼각형 출력
	static void triangleLB(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
