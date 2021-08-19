package chap04;

import java.util.Scanner;

public class IntQueueTester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntQueue n = new IntQueue(10);

		while (true) {
			System.out.println();
			System.out.println("현재 데이터 수 :  " + n.size() + " / " + n.capacity());
			System.out.println("현재 값");
			System.out.print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (5)전체삭제 (6)비움여부 (7)가득여부 (8)인덱스 (9)검색 (0)종료 : ");
			int menu = sc.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: { // enqueue
				System.out.print("데이터 : ");
				x = sc.nextInt();
				try {
					n.enque(x);

				} catch (IntQueue.OverflowIntQueueException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			}
			case 2: { // dequeue
				try {
					x = n.deque();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("스택이 비었습니다.");
				}
				break;
			}
			case 3: { // 피크
				try {
					x = n.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntQueue.EmptyIntQueueException e) {
					System.out.println("스택이 비었습니다.");
				}
				break;
			}
			case 4: { // 덤프
				n.dump();
				break;
			}
			case 5: { // 전체 삭제
				n.clear();
				break;
			}
			case 6: { // 비움 여부
				if (n.isEmpty())
					System.out.println("스택은 비어있습니다.");
				else
					System.out.println("스택은 비어 있지 않습니다.");
				break;
			}
			case 7: { // 가득 여부
				if (n.isFull())
					System.out.println("스택은 가득 찼습니다.");
				else
					System.out.println("스택은 가득 차지 않았습니다.");
				break;
			}
			case 8:
				System.out.print("찾고자 하는 값을 입력 : ");
				x = sc.nextInt();
				System.out.println(x + "는 " + n.indexOf(x) + "에 있습니다.");
				break;
			case 9:
				System.out.print("찾고자 하는 값을 입력 : ");
				x = sc.nextInt();
				System.out.println(x + "는 " + n.search(x) + "번째에 있습니다.");
				break;
			default:
				System.out.println("선택 가능한 메뉴가 아닙니다.");
			}

		}
	}
}
