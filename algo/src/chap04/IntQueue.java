package chap04;

public class IntQueue {
	private int max; // ť�� �뷮
	private int front; // ù ��° ��� Ŀ��
	private int rear; // ������ ��� Ŀ��
	private int num; // ���� ������ ��
	private int[] que; // ť ��ü

	// ���� �� ���� : ť�� ��� ����
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	// ���� �� ���� : ť�� ����
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}

	// ������
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// ť ��ť(enqueue)
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= max)
			throw new OverflowIntQueueException();
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}

	// ť ��ť (dequeue)
	public int deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	// ��ť ������ �� Ȯ�� (Ŀ�� �̵� ����)
	public int peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		return que[front];
	}

	// ť �˻�, ������ �ε��� ��ȯ, ���н� -1 ��ȯ
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x)
				return que[idx];
		}
		return -1;
	}

	// �迭�� �ε����� �ƴ� �� ��°�� ��ġ�ϰ� �ִ��� ��ȯ
	// ������ 0, ������ 1���� ��ġ ��ȯ
	public int search(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x)
				return i + 1;
		}
		return 0;
	}

	// ť ���
	public void clear() {
		num = front = rear = 0;
	}

	// ť �뷮 Ȯ��
	public int capacity() {
		return max;
	}

	// ť�� �׿� �ִ� ������ �� Ȯ��
	public int size() {
		return num;
	}

	// ť ��� �ִ��� ����
	public boolean isEmpty() {
		return num <= 0;
	}

	// ť ���� á���� ����
	public boolean isFull() {
		return num >= max;
	}

	// ť ���� ��� �����͸� �Է� ������ ���
	public void dump() {
		if (num <= 0)
			System.out.println("ť�� ��� �ֽ��ϴ�.");
		else {
			for (int i = 0; i < num; i++) {
				System.out.print("====");
			}
			System.out.println();
			System.out.print("| ");
			for (int i = 0; i < num; i++) {
				int idx = (i + front) % max;
				System.out.print(idx + " | ");
			}
			System.out.println();
			for (int i = 0; i < num; i++) {
				System.out.print("====");
			}
			System.out.println();
			System.out.print("| ");
			for (int i = 0; i < num; i++) {
				int idx = (i + front) % max;
				System.out.print(que[idx] + " | ");
			}
			System.out.println();
			for (int i = 0; i < num; i++) {
				System.out.print("====");
			}
			System.out.println();
		}
	}
}
