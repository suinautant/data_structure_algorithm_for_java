package chap09;

import java.util.Comparator;
//import java.util.Iterator;
import java.util.Scanner;

public class LinkedListTester {
	// �������� ��ĵ ����
	static Scanner sc = new Scanner(System.in);

	// ��ȣ�� �̸��� ������ ��ü
	static class Data {
		static final int NO = 1;
		static final int NAME = 2;

		private Integer no;
		private String name;

		// ���ڿ� ��ȯ
		// ��) (10) ȫ�浿
		public String toString() {
			return "(" + no + ")" + name;
		}

		// ������ �Է�
		// guide : �޴� ���� ����
		// sw: NO Ȥ�� NAME Ȥ�� NO|NAME
		// NO = 1, NAME = 2, NO|NAME = 3 (1 OR 2�̹Ƿ� 3)
		// NO�� ��� ��ȣ�� �Է�
		// NAME�� ��� �̸��� �Է�
		// NO|NAME�� ��� ��ȣ�� �̸� �Է�
		// 3�� 1�� 2 &�����ϸ� ������� 1�� 2�̱� ����
		void ScanData(String guide, int sw) {
			System.out.println(guide + "�� �����͸� �Է��ϼ���.");

			if ((sw & NO) == NO) {
				System.out.print("��ȣ : ");
				no = sc.nextInt();
			}
			if ((sw & NAME) == NAME) {
				System.out.print("�̸� : ");
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

	// �͸� ��ü ���� 
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
		ADD_FIRST("�Ӹ��� ��带 ����"),
		ADD_LAST("������ ��带 ����"),
		RMV_FIRST("�Ӹ� ��带 ����"),
		RMV_LAST("���� ��带 ����"),
		RMV_CRNT("���� ��带 ����"),
		CLEAR("��� ��带 ����"),
		SEARCH_NO("��ȣ�� �˻�"),
		SEARCH_NAME("�̸����� �˻�"),
		NEXT("���� ���� �̵�"),
		PRINT_CRNT("���� ��带 ���"),
		DUMP("��� ��带 ���"),
		TERMINATE("����");

		private final String message;

		// values() enum���� ������ ���� �迭�� ��ȯ
		// Enum.orinal() : enum�� ���� �� ���� ���� ��ȯ
		// �ε��� �� ���� enum �� ��ȯ
		static Menu menuAt(int idx) {
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		// ������ Menu()�� �̿��� ��� �׸� �߰�
		//		Menu(String string) {
		//			message = string;
		Menu(String message) {
			this.message = message;
		}

		String getMessage() {
			return message;
		}

	}

	// �޴� enum ��� ��� 
	static void printMenu() {
		for (Menu m : Menu.values())
			System.out.println(m);
	}

	// �޴� ����
	static Menu SelectMenu() {
		int key;
		// �Է� ���� enum ���� ��� ��� ��� �ݺ�
		do {
			// �޴� ���
			for (Menu m : Menu.values()) {
				String tmpString = "(" + m.ordinal() + ")" + m.getMessage();
				// System.out.printf("(%d) %25s ", m.ordinal(), m.getMessage());
				System.out.printf("%-20s", tmpString);
				// �� ���� �� ���� ���
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.TERMINATE.ordinal())
					System.out.println();
			}
			// �޴� ���ð� �Է�
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());
		// ���� �� ������ ��� �� ��ȯ
		return Menu.menuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data ptr;
		Data temp = new Data();
		LinkedList<Data> list = new LinkedList<Data>();

		// �Է� ���� ���� �̿��� ��� �ݺ�
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
				// Comparator �͸� ��üȭ�� Ŭ���� �и�
				ptr = list.search(temp, NO_ORDER);
				if (ptr == null)
					System.out.println("�� ��ȣ�� �����Ͱ� �����ϴ�.");
				else
					System.out.println("�˻� ���� : " + ptr);
				break;
			case SEARCH_NAME:
				temp.ScanData(menu.getMessage(), Data.NAME);
				// ptr = list.search(temp, Data.NAME_ORDER);
				// Comparator �͸� ��üȭ�� Ŭ���� �и�
				ptr = list.search(temp, NAME_ORDER);
				if (ptr == null)
					System.out.println("�� �̸��� �����Ͱ� �����ϴ�.");
				else
					System.out.println("�˻� ���� : " + ptr);
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
