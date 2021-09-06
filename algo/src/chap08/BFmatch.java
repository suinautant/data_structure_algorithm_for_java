package chap08;

import java.util.Iterator;
import java.util.Scanner;

/*
* �⺻ �ۼ�
* �������� Q1 �߰� : ���� �� �� Ƚ�� ���
*/
public class BFmatch {
	private static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("�ؽ�Ʈ : ");
		String s1 = sc.next();

		System.out.print("���� : ");
		String s2 = sc.next();

//		int idx = bfMatch(s1, s2);
		int idx = bfMatchLast(s1, s2);

		if (idx == -1)
			System.out.println("�ؽ�Ʈ�� ������ �����ϴ�.");
		else {
			int len = 0;
			for (int i = 0; i < idx; i++)
				len += s1.substring(i, i + 1).getBytes().length;
			len += s2.length();

			System.out.println();
			System.out.println((idx + 1) + "��° ���ں��� ��ġ�մϴ�.");
			System.out.println("�� �� : " + s1);
			// len =10�� ��� %%10s -> %10s�� ����ϱ� ���� format()
			System.out.printf(String.format("�� �� : %%%ds\n", len), s2);
			System.out.println("�� �� Ƚ���� " + count + "�Դϴ�.\n");
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
		// pat ���̸�ŭ pp�� �����ϸ� ���� ã�� ��
		if (pp == ptn.length())
			return pt - pp;
		// ���ڿ� �˻� ���н�
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
