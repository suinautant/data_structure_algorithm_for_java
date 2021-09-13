package chap09;

import java.util.Comparator;
//import java.util.Iterator;
import java.util.Scanner;

public class LinkedListTester {
	// 전역에서 스캔 변수
	static Scanner sc = new Scanner(System.in);

	// 번호와 이름을 가지는 객체
	static class Data {
		static final int NO = 1;
		static final int NAME = 2;

		private Integer no;
		private String name;

		// 문자열 반환
		// 예) (10) 홍길동
		public String toString() {
			return "(" + no + ")" + name;
		}

		// 데이터 입력
		// guide : 메뉴 동작 설명
		// sw: NO 혹은 NAME 혹은 NO|NAME
		// NO = 1, NAME = 2, NO|NAME = 3 (1 OR 2이므로 3)
		// NO일 경우 번호만 입력
		// NAME일 경우 이름만 입력
		// NO|NAME일 경우 번호와 이름 입력
		// 3은 1과 2 &연산하면 결과값이 1과 2이기 때문
		void ScanData(String guide, int sw) {
			System.out.println(guide + "할 데이터를 입력하세요.");

			if ((sw & NO) == NO) {
				System.out.print("번호 : ");
				no = sc.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("이름 : ");
				name = sc.next();
			}
		}

		/*
		public static final Comparator<Data> NO_ORDER = new NoOrderComparator();
		private static class NoOrderComparator implements Comparator<Data> {
			public int compare(Data d1, Data d2) {
				return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
			}
		}
		
		public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();
		private static class NameOrderComparator implements Comparator<Data> {
			public int compare(Data d1, Data d2) {
				return d1.name.compareTo(d2.name);
			}
		}
		*/
	}

	// 익명 객체 구현 
	public static final Comparator<Data> NO_ORDER = new Comparator<Data>() {
		@Override
		public int compare(Data d1, Data d2) {
			return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
		}
	};

	public static final Comparator<Data> NAME_ORDER = new Comparator<Data>() {
		@Override
		public int compare(Data d1, Data d2) {
			return d1.name.compareTo(d2.name);
		}
	};

	enum Menu {
		ADD_FIRST("머리에 노드를 삽입"),
		ADD_LAST("꼬리에 노드를 삽입"),
		RMV_FIRST("머리 노드를 삭제"),
		RMV_LAST("꼬리 노드를 삭제"),
		RMV_CRNT("선택 노드를 삭제"),
		CLEAR("모든 노드를 삭제"),
		SEARCH_NO("번호로 검색"),
		SEARCH_NAME("이름으로 검색"),
		NEXT("선택 노드로 이동"),
		PRINT_CRNT("선택 노드를 출력"),
		DUMP("모든 노드를 출력"),
		TERMINATE("종료");

		private final String message;

		// values() enum으로 저장한 값을 배열로 반환
		// Enum.orinal() : enum에 정의 된 순서 값을 반환
		// 인덱스 값 비교해 enum 값 반환
		static Menu menuAt(int idx) {
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		// 생성자 Menu()을 이용할 경우 항목 추가
		//		Menu(String string) {
		//			message = string;
		Menu(String message) {
			this.message = message;
		}

		String getMessage() {
			return message;
		}

	}

	// 메뉴 enum 상수 출력 
	static void printMenu() {
		for (Menu m : Menu.values())
			System.out.println(m);
	}

	// 메뉴 선택
	static Menu SelectMenu() {
		int key;
		// 입력 값이 enum 값을 벗어날 경우 계속 반복
		do {
			// 메뉴 출력
			for (Menu m : Menu.values()) {
				String tmpString = "(" + m.ordinal() + ")" + m.getMessage();
				// System.out.printf("(%d) %25s ", m.ordinal(), m.getMessage());
				System.out.printf("%-20s", tmpString);
				// 한 행이 세 개씩 출력
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
					System.out.println();
			}
			// 메뉴 선택값 입력
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());
		// 선택 된 열거형 상수 값 반환
		return Menu.menuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data ptr;
		Data temp = new Data();
		LinkedList<Data> list = new LinkedList<Data>();

		// 입력 값이 종료 이외일 경우 반복
		do {
			switch (menu = SelectMenu()) {
			case ADD_FIRST:
				data = new Data();
				data.ScanData(menu.getMessage(), Data.NO | Data.NAME);
				list.addFirst(data);
				break;
			case ADD_LAST:
				data = new Data();
				data.ScanData(menu.getMessage(), Data.NO | Data.NAME);
				list.addLast(data);
				break;
			case RMV_FIRST:
				list.removeFirst();
				break;
			case RMV_LAST:
				list.removeLast();
				break;
			case RMV_CRNT:
				list.removeCurrentNode();
				break;
			case SEARCH_NO:
				temp.ScanData(menu.getMessage(), Data.NO);
				// ptr = list.search(temp, Data.NO_ORDER);
				// Comparator 익명 객체화와 클래스 분리
				ptr = list.search(temp, NO_ORDER);
				if (ptr == null)
					System.out.println("그 번호의 데이터가 없습니다.");
				else
					System.out.println("검색 성공 : " + ptr);
				break;
			case SEARCH_NAME:
				temp.ScanData(menu.getMessage(), Data.NAME);
				// ptr = list.search(temp, Data.NAME_ORDER);
				// Comparator 익명 객체화와 클래스 분리
				ptr = list.search(temp, NAME_ORDER);
				if (ptr == null)
					System.out.println("그 이름의 데이터가 없습니다.");
				else
					System.out.println("검색 성공 : " + ptr);
				break;
			case NEXT:
				list.next();
				break;
			case PRINT_CRNT:
				list.printCurrentNode();
				break;
			case DUMP:
				list.dump();
				break;
			case CLEAR:
				list.clear();
				break;
			}
			System.out.println();
		} while (menu != Menu.TERMINATE);
	}
}
