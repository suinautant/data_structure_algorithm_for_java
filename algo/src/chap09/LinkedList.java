package chap09;

import java.util.Comparator;

public class LinkedList<E> {
	class Node<E> {
		private E data; // data (데이터)
		private Node<E> next; // next node (다음 노드)

		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head; // first node (첫 노드)
	private Node<E> crnt; // current (현재 노드)

	public LinkedList() {
		head = crnt = null;
	}

	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head;

		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}

	public void addFirst(E obj) {
		Node<E> ptr = head;
		head = crnt = new Node<E>(obj, ptr);
	}

	public void addLast(E obj) {
		// 헤드가 없으면 첫 위치에 노드 추가
		if (head == null)
			addFirst(obj);
		else {
			Node<E> ptr = head;
			// 마지막 노드로 이동
			while (ptr.next != null)
				ptr = ptr.next;
			// 마지막 노드에서 새로운 노드 추가
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}

	public void removeFirst() {
		if (head != null)
			head = crnt = head.next;
	}

	public void removeLast() {
		if (head != null) {
			if (head.next == null)
				removeFirst();
			else {
				Node<E> ptr = head;
				Node<E> pre = head;

				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;
				crnt = pre;
			}
		}
	}

	public void remove(Node<E> p) {
		if (head != null) {
			if (p == head)
				removeFirst();
			else {
				Node<E> ptr = head;

				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null)
						return;
				}
				ptr.next = p.next;
				crnt = ptr;
			}
		}
	}

	public void removeCurrentNode() {
		remove(crnt);
	}

	public void clear() {
		while (head != null)
			removeFirst();
		crnt = null;
	}

	public boolean next() {
		if (crnt == null || crnt.next == null)
			return false;
		crnt = crnt.next;
		return true;
	}

	public void printCurrentNode() {
		if (crnt == null)
			System.out.println("선택한 노드가 없습니다.");
		else
			System.out.println(crnt.data);
	}

	public void dump() {
		Node<E> ptr = head;

		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}
}
