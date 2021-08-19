package chap04;

import java.util.Scanner;

public class IntQueueTester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntQueue n = new IntQueue(10);

		while (true) {
			System.out.println();
			System.out.println("���� ������ �� :  " + n.size() + " / " + n.capacity());
			System.out.println("���� ��");
			System.out.print("(1)��ť (2)��ť (3)��ũ (4)���� (5)��ü���� (6)��򿩺� (7)���濩�� (8)�ε��� (9)�˻� (0)���� : ");
			int menu = sc.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: { // enqueue
				System.out.print("������ : ");
				x = sc.nextInt();
				try {
					n.enque(x);

				} catch (IntQueue.OverflowIntQueueException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
			}
			case 2: { // dequeue
				try {
					x = n.deque();
					System.out.println("���� �����ʹ� " + x + "�Դϴ�.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("������ ������ϴ�.");
				}
				break;
			}
			case 3: { // ��ũ
				try {
					x = n.peek();
					System.out.println("��ũ�� �����ʹ� " + x + "�Դϴ�.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("������ ������ϴ�.");
				}
				break;
			}
			case 4: { // ����
				n.dump();
				break;
			}
			case 5: { // ��ü ����
				n.clear();
				break;
			}
			case 6: { // ��� ����
				if (n.isEmpty())
					System.out.println("������ ����ֽ��ϴ�.");
				else
					System.out.println("������ ��� ���� �ʽ��ϴ�.");
				break;
			}
			case 7: { // ���� ����
				if (n.isFull())
					System.out.println("������ ���� á���ϴ�.");
				else
					System.out.println("������ ���� ���� �ʾҽ��ϴ�.");
				break;
			}
			case 8:
				System.out.print("ã���� �ϴ� ���� �Է� : ");
				x = sc.nextInt();
				System.out.println(x + "�� " + n.indexOf(x) + "�� �ֽ��ϴ�.");
				break;
			case 9:
				System.out.print("ã���� �ϴ� ���� �Է� : ");
				x = sc.nextInt();
				System.out.println(x + "�� " + n.search(x) + "��°�� �ֽ��ϴ�.");
				break;
			default:
				System.out.println("���� ������ �޴��� �ƴմϴ�.");
			}

		}
	}
}
