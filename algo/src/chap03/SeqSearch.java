package chap03;

import java.util.Scanner;

public class SeqSearch {
	static int[] seqSearch(int[] a, int key) {
		int[] result = new int[a.length];
		result[0] = -1;
		int j = 0;

		for (int i = 0; i < a.length; i++) {
			System.out.print("   | ");
			for (int k = 0; k < i; k++) {
				System.out.print("  ");
			}
			System.out.print("*");
			System.out.println();

			System.out.print(" " + i + " |");
			for (int k = 0; k < a.length; k++) {
				System.out.print(" " + a[k]);
			}
			System.out.println();

			if (a[i] == key) {
				result[j++] = i;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num];

		for (int i = 0; i < x.length; i++) {
			System.out.print(i + "번째 값 : ");
			x[i] = sc.nextInt();
		}

		System.out.print("검색 할 값 : ");
		int key = sc.nextInt();

		System.out.print("   |");
		for (int i = 0; i < x.length; i++) {
			System.out.print(" " + i);
		}
		System.out.println();
		System.out.println("---+-------------------------------");

		int[] idx = seqSearch(x, key);

		System.out.println();
		if (idx[0] == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else {
			for (int i = 0; i < idx.length; i++) {
				if (idx[i] != 0)
					System.out.println(key + "는 " + idx[i] + "번째에 있습니다.");
			}
		}
	}
}
