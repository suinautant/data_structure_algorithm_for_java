package chap11;

import java.util.Scanner;

public class ChainHashTester {
	static Scanner sc = new Scanner(System.in);
	
	static class Data{
		static final int NO=1;
		static final int NAME=2;
		
		private Integer no;
		private String name;
		
		Integer keyCode() {
			return no;
		}
		
		public String toString() {
			return name;
		}
		
		
	}
}
