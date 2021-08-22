package chap05;

import java.util.Scanner;

public class Recur3 {
	static void recur(int n) {
		if (n > 0) {
			recur(n - 1);
			recur(n - 2);
			System.out.println(n);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int x = sc.nextInt();
		recur(x);
	}
}
