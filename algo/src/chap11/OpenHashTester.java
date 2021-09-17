package chap11;

import java.util.Scanner;

public class OpenHashTester {
	static Scanner sc = new Scanner(System.in);

	static class Data {
		static final int NO   = 1;
		static final int NAME = 2;

		private Integer no;
		private String  name;

		Integer keyCode() {
			return no;
		}

		@Override
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
	} // EOC Data

	enum Menu {
		ADD("�߰�"),
		REMOVE("����"),
		SEARCH("�˻�"),
		DUMP("���"),
		TERMINATE("����");

		private final String message;

		static Menu MenuAt(int idx) {
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) {
			message = string;
		}

		String getMessage() {
			return message;
		}
	} // EOE Menu

	static Menu SelectMenu() {
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu;
		Data data;
		Data temp = new Data();

		OpenHash<Integer, Data> hash = new OpenHash<>(13);

		do {
			switch (menu = SelectMenu()) {
			case ADD:
				data = new Data();
				data.scanData("�߰�", Data.NO | Data.NAME);
				int k = hash.add(data.keyCode(), data);
				switch (k) {
				case 1:
					System.out.println("�� Ű ���� �̹� ��ϵǾ� �ֽ��ϴ�.");
					break;
				case 2:
					System.out.println("�ؽ� ���̺��� ���� á���ϴ�.");
					break;
				}
				break;

			case REMOVE:
				temp.scanData("����", Data.NO);
				hash.remove(temp.keyCode());
				break;

			case SEARCH:
				temp.scanData("�˻�", Data.NO);
				Data t = hash.search(temp.keyCode());
				if (t != null)
					System.out.println("�� Ű�� ���� �����ʹ� " + t + "�Դϴ�.");
				else
					System.out.println("�� �����Ͱ� �����ϴ�.");
				break;

			case DUMP:
				hash.dump();
				break;
			}
		} while (menu != Menu.TERMINATE);
	}
} // EOD
