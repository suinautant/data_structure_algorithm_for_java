package chap08;

import java.util.Scanner;

public class BMmatch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("텍스트 : ");
		String s1 = sc.next();
		System.out.print("패턴 : ");
		String s2 = sc.next();

		int idx = bmMatch(s1, s2);

		if (idx == -1)
			System.out.println("테스트에 패턴이 포함되지 않습니다.");
		else {
			int len = 0;
			for (int i = 0; i < idx; i++)
				len += s1.substring(i, i + 1).getBytes().length;
			len += s2.length();

			System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
			System.out.println("전체 : " + s1);
			System.out.printf(String.format("패턴 : %%%ds\n", len), s2);

		}

	}

	private static int bmMatch(String txt, String pat) {
		int pt;
		int pp;
		int txtLen = txt.length();
		int patLen = pat.length();
		final int MAX_VALUE = Character.MAX_VALUE + 1;
		int[] skip = new int[MAX_VALUE];

		for (pt = 0; pt < MAX_VALUE; pt++)
			skip[pt] = patLen;
		for (pt = 0; pt < patLen - 1; pt++)
			skip[pat.charAt(pt)] = patLen - pt - 1;

		while (pt < txtLen) {
			pp = patLen - 1;

			while (txt.charAt(pt) == pat.charAt(pp)) {
				if (pp == 0)
					return pt;
				pp--;
				pt--;
			}
			pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
		}

		return -1;
	}
}
