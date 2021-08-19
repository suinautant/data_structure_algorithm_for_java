package chap02;

import java.util.Scanner;

public class MaxOfArray {

	public static int minOf(int[] intArray) {
		int minHeight = intArray[0];
		for (int i = 0; i < intArray.length; i++) {
			if (minHeight > intArray[i])
				minHeight = intArray[i];
		}
		return minHeight;
	}

	public static int maxOf(int[] intArray) {
		int maxHeight = intArray[0];
		for (int i = 0; i < intArray.length; i++) {
			if (maxHeight < intArray[i])
				maxHeight = intArray[i];
		}
		return maxHeight;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("��� �� : ");
		int arrayNum = sc.nextInt();

		int[] height = new int[arrayNum];
		for (int i = 0; i < height.length; i++) {
			System.out.print("height[" + i + "] : ");
			height[i] = sc.nextInt();
		}

		System.out.println("[�޴�] ");
		System.out.println("1) �ִ밪 2) �ּҰ�");
		System.out.println("���� : ");
		int choiceMenu = sc.nextInt();

		switch (choiceMenu) {
		case 1: {
			System.out.println("�ִ밪 : " + maxOf(height));
			break;
		}
		case 2: {
			System.out.println("�ּҰ� : " + minOf(height));
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choiceMenu);
		}

	}

}
