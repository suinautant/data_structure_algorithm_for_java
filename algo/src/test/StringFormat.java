package test;

import java.util.Scanner;

public class StringFormat {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "StringFormat";

		while (true) {
			System.out.print("\n�ڸ� �� : ");
			int idx = sc.nextInt();

			if (idx == 0)
				break;

			System.out.println("ǥ�� : %" + idx + "s");
			System.out.println("|||||||||||||||||||||||||||||||");
			System.out.printf(String.format("%%%ds\n", idx), s);
		}
	}
}
