package chap04;

// int �� ���� 
public class GStack<E> {
	private int max; // ���� �뷮
	private int ptr; // ���� ������ (���� ������ �� �ִ� ��ġ)
	private E[] stk; // ���� ��ü

	// ���� �߻� �ּ� ó��
	// ���� �� ���� : ������ ��� ����
	// �ø��� ���� �߻����� �߰�
	public static class EmptyGStackException extends RuntimeException {
		public EmptyGStackException() {
		}
	}

	// ���� �� ���� : ������ ���� ��
	// �ø��� ���� �߻����� �߰�
	public static class OverflowGStackException extends RuntimeException {
		public OverflowGStackException() {
		}
	}

	// ������
	public GStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			// �迭 ���� ����
//			stk = new E[max];
			// E Ÿ������ ����ȯ
			stk = (E[]) new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// ���� Ǫ�� ����
	// ������ ��ġ�� �� ���� �� ������ ��ġ �� 1����
	public E push(E x) throws OverflowGStackException {
		if (ptr >= max)
			throw new OverflowGStackException();
		// GSTackTester main �޼��忡�� ���� String���� ��ȯ�� ���� �߻�
		return stk[ptr++] = x;
	}

	// ���� �� ����
	// ptr ��ġ �̵� �� �� ����
	public E pop() throws EmptyGStackException {
		if (ptr <= 0)
			throw new EmptyGStackException();
		return stk[--ptr];
	}

	// ������ �̵� ���� ���� Ȯ��
	public E peek() throws EmptyGStackException {
		if (ptr <= 0)
			throw new EmptyGStackException();
		return stk[ptr - 1];
	}

	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--)
			// ���� ã�� ��� �ش� �ε��� ��ȯ
			if (stk[i].equals(x))
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
