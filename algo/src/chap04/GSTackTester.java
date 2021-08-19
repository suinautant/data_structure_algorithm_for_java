package chap04;

import java.util.Scanner;

public class GSTackTester {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		GStack<Integer> s = new GStack<>(5);
		GStack<String> s = new GStack<String>(5);

		while (true) {
			System.out.println();
			System.out.println("���� ������ �� :  " + s.size() + " / " + s.capacity());
			System.out.print("(1)Ǫ�� (2)�� (3)��ũ (4)���� (5)��ü���� (6)��򿩺� (7)���濩�� (0)���� : ");
			int menu = sc.nextInt();
			if (menu == 0)
				break;

//			int x;
			switch (menu) {
			case 1: { // Ǫ��
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					s.push(x);

				} catch (Exception e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
			}
			case 2: { // ��
				try {
					x = s.pop();
					System.out.println("���� �����ʹ� " + x + "�Դϴ�.");
				} catch (Exception e) {
					System.out.println("������ ������ϴ�.");
				}
				break;
			}
			case 3: { // ��ũ
				try {
					x = s.peek();
					System.out.println("��ũ�� �����ʹ� " + x + "�Դϴ�.");
				} catch (Exception e) {
					System.out.println("������ ������ϴ�.");
				}
				break;
			}
			case 4: { // ����
				s.dump();
				break;
			}
			case 5: { // ��ü ����
				s.clear();
				break;
			}
			case 6: { // ��� ����
				if(s.isEmpty())
					System.out.println("������ ����ֽ��ϴ�.");
				else 
					System.out.println("������ ��� ���� �ʽ��ϴ�.");
				break;
			}
			case 7: { // ���� ä�� ����
				if(s.isFull())
					System.out.println("������ ���� á���ϴ�.");
				else 
					System.out.println("������ ���� ���� �ʾҽ��ϴ�.");
				break;
			}
			default:
				System.out.println("���� ������ �޴��� �ƴմϴ�.");
			}

		}
	}
}
