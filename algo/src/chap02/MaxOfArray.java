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

		System.out.print("사람 수 : ");
		int arrayNum = sc.nextInt();

		int[] height = new int[arrayNum];
		for (int i = 0; i < height.length; i++) {
			System.out.print("height[" + i + "] : ");
			height[i] = sc.nextInt();
		}

		System.out.println("[메뉴] ");
		System.out.println("1) 최대값 2) 최소값");
		System.out.println("선택 : ");
		int choiceMenu = sc.nextInt();

		switch (choiceMenu) {
		case 1: {
			System.out.println("최대값 : " + maxOf(height));
			break;
		}
		case 2: {
			System.out.println("최소값 : " + minOf(height));
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choiceMenu);
		}

	}

}
