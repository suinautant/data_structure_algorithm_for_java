package chap08;

import java.util.Iterator;
import java.util.Scanner;

/*
* 기본 작성
* 연습문제 Q1 추가 : 과정 및 비교 횟수 출력
*/
public class BFmatch {
	private static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("텍스트 : ");
		String s1 = sc.next();

		System.out.print("패턴 : ");
		String s2 = sc.next();

//		int idx = bfMatch(s1, s2);
		int idx = bfMatchLast(s1, s2);

		if (idx == -1)
			System.out.println("텍스트에 패턴이 없습니다.");
		else {
			int len = 0;
			for (int i = 0; i < idx; i++)
				len += s1.substring(i, i + 1).getBytes().length;
			len += s2.length();

			System.out.println();
			System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
			System.out.println("입 력 : " + s1);
			// len =10일 경우 %%10s -> %10s로 사용하기 위한 format()
			System.out.printf(String.format("패 턴 : %%%ds\n", len), s2);
			System.out.println("비교 한 횟수는 " + count + "입니다.\n");
		}
	}

	private static int bfMatchLast(String txt, String ptn) {
		int txtLen = txt.length();
		int ptnLen = ptn.length();
		int pt = txtLen - 1;
		int pp = ptnLen - 1;
		count = 0;

		while (pt >= 0 && pp >= 0) {
			System.out.println("[ " + ++count + " ]");
			System.out.println(txt);
			System.out.println(addSpace(pt) + (txt.charAt(pt) == ptn.charAt(pp) ? "+" : "|"));
			System.out.println(addSpace(pt - pp) + ptn);

			if (txt.charAt(pt) == ptn.charAt(pp)) {
				pt--;
				pp--;
			} else {
				pt = pt - pp + 1;
				pp = ptnLen - 1;
			}
		}
		if (pp == -1)
			return pt - pp;
		return -1;
	}

	private static int bfMatch(String txt, String ptn) {
		int pt = 0;
		int pp = 0;
		count = 0;

		while (pt != txt.length() && pp != ptn.length()) {
			System.out.println("[ " + ++count + " ]");
			System.out.println(txt);
			System.out.println(addSpace(pt) + (txt.charAt(pt) == ptn.charAt(pp) ? "+" : "|"));
			System.out.println(addSpace(pt - pp) + ptn);

			if (txt.charAt(pt) == ptn.charAt(pp)) {
				pt++;
				pp++;
			} else {
				pt = pt - pp + 1;
				pp = 0;
			}
		}
		// pat 길이만큼 pp가 증가하면 값을 찾은 것
		if (pp == ptn.length())
			return pt - pp;
		// 문자열 검색 실패시
		return -1;
	}

	private static String addSpace(int i) {
		String space = "";
		for (int j = 0; j < i; j++) {
			space += " ";
		}
		return space;
	}

}
