package chap05;

// int �� ���� 
public class IntStack {
	private int max; // ���� �뷮
	private int ptr; // ���� ������ (���� ������ �� �ִ� ��ġ)
	private int[] stk; // ���� ��ü

	// ���� �� ���� : ������ ��� ����
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// ���� �� ���� : ������ ���� ��
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// ������
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// ���� Ǫ�� ����
	// ������ ��ġ�� �� ���� �� ������ ��ġ �� 1����
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

	// ���� �� ����
	// ptr ��ġ �̵� �� �� ����
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	// ������ �̵� ���� ���� Ȯ��
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	// ���� �˻�, ������ �ε��� ��ȯ, ���н� -1 ��ȯ
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--)
			// ���� ã�� ��� �ش� �ε��� ��ȯ
			if (stk[i] == x)
				return i;
		// ���� ���� ��� -1 ��ȯ
		return -1;
	}

	// ���� ���
	public void clear() {
		ptr = 0;
	}

	// ���� �뷮 ��ȯ
	public int capacity() {
		return max;
	}

	// ���ÿ� �׿� �ִ� ������ ���� ��ȯ
	public int size() {
		return ptr;
	}

	// ���� ��� �ִ��� ���� Ȯ��
	public boolean isEmpty() {
		return ptr <= 0;
	}

	// ������ ���� á�°�?
	public boolean isFull() {
		return ptr >= max;
	}

	// ���� ���� ��� �����͸� �ٴڿ��� ����� ������ ���
	public void dump() {
		if (ptr <= 0)
			System.out.println("������ ��� �ֽ��ϴ�.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}

}
