package chap06;

import java.util.Arrays;

public class ArraysSortTester {
	public static void main(String[] args) {
		int[] x = { 22, 5, 11, 32, 120, 68, 70 };
		
		print(x);
		Arrays.sort(x);
		print(x);
	}
	
	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}
		System.out.println();
	}
}
