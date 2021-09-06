package chap07;

public class InstSetTester {
	public static void main(String[] args) {
		IntSet s1 = new IntSet(20);
		IntSet s2 = new IntSet(20);
		IntSet s3 = new IntSet(20);
		IntSet s4 = new IntSet(20);
		IntSet s5 = new IntSet(5);

		s1.add(10);
		s1.add(15);
		s1.add(20);
		s1.add(25);

		s1.copyTo(s2);
		s2.add(12);
		s2.remove(25);

		s3.copyFrom(s2);

		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		System.out.println("s4 = " + s4);
		System.out.println("s5 = " + s5);

		System.out.println("���� s1�� 15�� " + (s1.contains(15) ? "���Ե˴ϴ�." : "���Ե��� �ʽ��ϴ�."));
		System.out.println("���� s2�� 25�� " + (s2.contains(25) ? "���Ե˴ϴ�." : "���Ե��� �ʽ��ϴ�."));
		System.out.println("���� s1�� s2�� " + (s1.equalTo(s2) ? "�����ϴ�." : "���� �ʽ��ϴ�."));
		System.out.println("���� s2�� s3�� " + (s2.equalTo(s3) ? "�����ϴ�." : "���� �ʽ��ϴ�."));

		s3.unionOf(s1, s2);

		System.out.println("���� s1�� s2�� �������� " + s3 + "�Դϴ�.");
		
		System.out.println("s4 = " + s4);
		System.out.println("���� s4�� " + (s4.isEmpty() ? "������ϴ�." : "������� �ʽ��ϴ�."));
		s4.add(20);
		System.out.println("s4 = " + s4);
		System.out.println("���� s4�� " + (s4.isEmpty() ? "������ϴ�." : "������� �ʽ��ϴ�."));
		
		System.out.println("s5 = " + s5);
		System.out.println("���� s5�� " + (s5.isFull() ? "�����մϴ�." : "�������� �ʽ��ϴ�."));
		s5.add(1);
		s5.add(2);
		s5.add(3);
		System.out.println("���� s5�� " + (s5.isFull() ? "�����մϴ�." : "�������� �ʽ��ϴ�."));
		s5.add(4);
		s5.add(5);
		System.out.println("s5 = " + s5);
		System.out.println("���� s5�� " + (s5.isFull() ? "�����մϴ�." : "�������� �ʽ��ϴ�."));
		
		s5.clear();
		System.out.println("s5 = " + s5);
		
		
	}
}
