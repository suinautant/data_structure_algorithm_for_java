package chap01;

import java.util.Scanner;

public class SumWhile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("1~n까지 더할 정수를 입력하세요 : ");
		int x = sc.nextInt();

		int sum = 0;
		for (int i = 1; i <= x; i++) {
			sum += i;
			System.out.println("i : " + i + " sum : " + sum);
		}

		System.out.println("합계는 : " + sum);
	}

}
