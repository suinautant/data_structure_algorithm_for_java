package chap05;

import java.util.Scanner;

public class Hanoi_char {
	static void move(int no, int x, int y) {
		char[] pillar = { 'A', 'B', 'C' };
		if (no > 1)
			move(no - 1, x, 6 - x - y);
		// 문자 배열과 인덱스 값 동일하게 하기 위해 x와 y의 값을 1씩 감소
		System.out.println("원반[" + no + "]을 " + pillar[x - 1] + "기둥에서 " + pillar[y - 1] + "기둥으로 옮김");
		if (no > 1)
			move(no - 1, 6 - x - y, y);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("하노이의 탑");
		System.out.print("원반 개수 : ");
		int n = sc.nextInt();

		move(n, 1, 3);
	}
}
