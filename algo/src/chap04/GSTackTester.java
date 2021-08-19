package chap04;

import java.util.Scanner;

public class GSTackTester {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
//		GStack<Integer> s = new GStack<>(5);
		GStack<String> s = new GStack<String>(5);

		while (true) {
			System.out.println();
			System.out.println("현재 데이터 수 :  " + s.size() + " / " + s.capacity());
			System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)전체삭제 (6)비움여부 (7)가득여부 (0)종료 : ");
			int menu = sc.nextInt();
			if (menu == 0)
				break;

//			int x;
			switch (menu) {
			case 1: { // 푸시
				System.out.print("데이터 : ");
				x = sc.nextInt();
				try {
					s.push(x);

				} catch (Exception e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;
			}
			case 2: { // 팝
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (Exception e) {
					System.out.println("스택이 비었습니다.");
				}
				break;
			}
			case 3: { // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (Exception e) {
					System.out.println("스택이 비었습니다.");
				}
				break;
			}
			case 4: { // 덤프
				s.dump();
				break;
			}
			case 5: { // 전체 삭제
				s.clear();
				break;
			}
			case 6: { // 비움 여부
				if(s.isEmpty())
					System.out.println("스택은 비어있습니다.");
				else 
					System.out.println("스택은 비어 있지 않습니다.");
				break;
			}
			case 7: { // 가득 채움 여부
				if(s.isFull())
					System.out.println("스택은 가득 찼습니다.");
				else 
					System.out.println("스택은 가득 차지 않았습니다.");
				break;
			}
			default:
				System.out.println("선택 가능한 메뉴가 아닙니다.");
			}

		}
	}
}
