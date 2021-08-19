package chap02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {

	private static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			max = max < a[i] ? a[i] : max;
		}
		return max;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("Ű�� �ִ밪�� ���մϴ�.");
		int num = rand.nextInt(10) + 1;
		System.out.print("����� : " + num);

		int[] height = new int[num];

		System.out.println("Ű ���� �Ʒ��� �����ϴ�.");
		for (int i = 0; i < num; i++) {
			height[i] = 100 + rand.nextInt(90);
			System.out.println("height[" + i + "] : " + height[i]);
		}
		System.out.println("�ִ밪�� " + maxOf(height) + "�Դϴ�.");
	}

}
