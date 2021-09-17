package chap10;

import java.util.Scanner;

public class BinTreeTester {
	static Scanner sc = new Scanner(System.in);

	static class Data {
		public static final int NO   = 1;
		public static final int NAME = 2;

		private Integer no;
		private String  name;

		Integer keyCode() {
			return no;
		}

		public String toString() {
			return name;
		}

		void scanData(String guide, int sw) {
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
	}

	enum Menu {
		ADD("����"),
		REMOVE("����"),
		SEARCH("�˻�"),
		PRINT("ǥ��"),
		TERMINATE("����");

		private final String message;

		static Menu MenuAt(int idx) {
			for (Menu m : Menu.values()) if (m.ordinal() == idx)
				return m;
			return null;
		}

		Menu(String string) {
			message = string;
		}

		String getMessage() {
			return message;
		}
	}

	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values()) System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.println(" : ");
			key = sc.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu                   menu;
		Data                   data;
		Data                   ptr;
		Data                   temp = new Data();
		BinTree<Integer, Data> tree = new BinTree<Integer, Data>();

		do {
			switch (menu = SelectMenu()) {
			case ADD:
				data = new Data();
				data.scanData("����", Data.NO | Data.NAME);
				tree.add(data.keyCode(), data);
				break;

			case REMOVE:
				temp.scanData("����", Data.NO);
				tree.remove(temp.keyCode());
				break;

			case SEARCH:
				temp.scanData("�˻�", Data.NO);
				ptr = tree.search(temp.keyCode());
				if (ptr != null)
					System.out.println("�� ��ȣ�� �̸��� " + ptr + "�Դϴ�.");
				else
					System.out.println("�ش� �����Ͱ� �����ϴ�.");
				break;

			case PRINT:
				tree.print();
				break;
			}
		} while (menu != Menu.TERMINATE);
	}
	// Enf of Document
}