package chap09;

import java.util.Comparator;

// ���� ����Ʈ Ŭ���� (�迭 Ŀ�� ����)
// free ����Ʈ : ������ ���� ���ڵ带 �����ϱ� ���� ���
public class AryLinkedList<E> {
	// ���
	class Node<E> {
		private E data;		// ������
		private int next;	// ����Ʈ�� ���� ������
		private int dnext;	// free ����Ʈ�� ���� ������

		void set(E data, int next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E>[] n;	// ����Ʈ ��ü
	private int size;		// ����Ʈ �뷮(���� ū ������ ��)
	private int max;		// ��� ���� ����
	private int head;		// �Ӹ� ���
	private int crnt;		// ���� ���
	private int deleted;	// free ����Ʈ�� �Ӹ� ���
	private static final int NULL = -1; // ���� ��� ���� : ����Ʈ ���� ��

	public AryLinkedList(int capacity) {
		head = crnt = max = deleted = NULL;
		try {
			n = new Node[capacity];
			for (int i = 0; i < capacity; i++)
				n[i] = new Node<E>();
		} catch (OutOfMemoryError e) { // �迭 ������ ����
			size = 0;
		}
	}

	// ������ �����ϴ� ���ڵ��� �ε��� ����
	private int getInsertIndex() {
		if (deleted == NULL) {	// ������ ���ڵ尡 ����
			if (max < size)
				return ++max;	// �� ���ڵ� ���
			else
				return NULL;	// �뷮 ��ħ
		} else {
			int rec = deleted;	// free ����Ʈ���� �Ӹ� rec�� ����
			deleted = n[rec].dnext;
			return rec;
		}
	}

	// recode idx�� free ����Ʈ�� ���
	private void deleteIndex(int idx) {
		if (deleted == NULL) {		// idx�� free����Ʈ�� �Ӹ��� ���
			deleted = idx;
			n[idx].dnext = NULL;
		} else {					// idx�� free����Ʈ�� �Ӹ��� ����
			int rec = deleted;
			deleted = idx;
			n[rec].dnext = rec;
		}
	}

	// ��� �˻�
	public E search(E obj, Comparator<? super E> c) {
		int ptr = head;									// ���� ��ĵ ���� ���

		while (ptr != NULL) {
			if (c.compare(obj, n[ptr].data) == 0) {		// �˻� ����
				crnt = ptr;
				return n[ptr].data;
			}
			ptr = n[ptr].next;							// ���� ��忡 �ָ�
		}
		return null;									// �˻� ����
	}

	// �Ӹ��� ��带 ����
	public void addFirst(E obj) {
		int ptr = head;				// ���� ���� �Ӹ� ���
		int rec = getInsertIndex();
		if (rec != NULL) {
			head = crnt = rec;		// �ε��� rec�� record�� ����
			n[head].set(obj, ptr);
		}
	}

	// ������ ��带 ����
	public void addLast(E obj) {
		if (head == NULL)					// ����Ʈ�� ��� ������ �Ӹ��� ����
			addFirst(obj);
		else {
			int ptr = head;
			while (n[ptr].next != NULL)
				ptr = n[ptr].next;
			int rec = getInsertIndex();
			if (rec != NULL) {				// �ε��� rec�� ���ڵ忡 ����
				n[ptr].next = crnt = rec;
				n[rec].set(obj, NULL);
			}
		}
	}

	// �Ӹ� ��带 ����
	public void removeFirst() {
		if (head != NULL) {				// ����Ʈ�� ��� ���� ������
			int ptr = n[head].next;
			deleteIndex(head);
			head = crnt = ptr;
		}
	}

	// ���� ��带 ����
	public void removeLast() {
		if (head != NULL) {
			if (n[head].next == NULL)	// ��尡 �ϳ��� ������ �Ӹ� ��� ����
				removeFirst();
			else {
				int ptr = head;			// ��ĵ ���� ���
				int pre = head;			// ��ĵ ���� ����� ���� ���

				while (n[ptr].next != NULL) {
					pre = ptr;
					ptr = n[ptr].next;
				}
				n[pre].next = NULL;		// pre�� ���� ���� ���� ���
				deleteIndex(pre);
				crnt = pre;
			}
		}
	}

	// recode ����
	public void remove(int p) {
		if (head != NULL) {
			if (p == head)
				removeFirst();				// �Ӹ� ��� ����
			else {
				int ptr = head;

				while (n[ptr].next != p) {
					ptr = n[ptr].next;
					if (ptr == NULL)		// p�� ����Ʈ�� �����ϴ�.
						return;
				}
				n[ptr].next = NULL;
				deleteIndex(ptr);
				n[ptr].next = n[p].next;
				crnt = ptr;
			}
		}
	}

	// ���� ��带 ����
	public void removeCurrentNode() {
		remove(crnt);
	}

	// ��� ��带 ����
	public void clear() {
		while (head != NULL)
			removeFirst();
		crnt = NULL;
	}

	// ���� ��带 �ϳ� �������� �̵�
	public boolean next() {
		if (crnt == NULL || n[crnt].next == NULL)
			return false;
		crnt = n[crnt].next;
		return true;
	}

	// ���� ��带 ���
	public void printCurrentNode() {
		if (crnt == NULL)
			System.out.println("���� ��尡 �����ϴ�.");
		else
			System.out.println(n[crnt].data);
	}

	// ��� ��带 ���
	public void dump() {
		int ptr = head;

		while (ptr != NULL) {
			System.out.println(n[ptr].data);
			ptr = n[ptr].next;
		}
	}
}
