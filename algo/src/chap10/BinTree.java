package chap10;

import java.util.Comparator;

public class BinTree<K, V> {
	// ���
	static class Node<K, V> {
		private K key;				// Ű ��
		private V data;				// ������
		private Node<K, V> left;	// ���� �ڽ� ���
		private Node<K, V> right;	// ������ �ڽ� ���

		// ������
		Node(K key, V data, Node<K, V> left, Node<K, V> right) {
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}

		K getKey() {
			return key;
		}

		V getValue() {
			return data;
		}

		void print() {
			System.out.println(data);
		}
		// End of Node class
	}

	private Node<K, V> root;
	private Comparator<? super K> comparator = null;

	// ����ִ� �����˻�Ʈ�� ����
	// �ڿ� ������ ���� ��� ���� �Ǵ�
	// Comparable : Integer, String ���
	// comparator �ʵ� : null
	public BinTree() {
		root = null;
	}

	// ����ִ� �����˻�Ʈ�� ����
	// ���ڷ� ��� ���� �Ǵ�
	// Comparator
	public BinTree(Comparator<? super K> comparator) {
		this();
		this.comparator = comparator;
	}

	// ��
	// BinTree()�� ���� �����ϸ� Comparable.compareTo �̿��� ��
	// comprator �� ������ Comparator.compare �̿��� ��
	// key1 > key2 : 1
	// key1 == key2 : 0
	// key1 < key2 : -1
	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
	}

	// Ű �˻�
	public V search(K key) {
		Node<K, V> p = root;

		while (true) {
			if (p == null)				// p �� ������  �˻� ����
				return null;
			int cond = comp(key, p.getKey());
			if (cond == 0)				// key�� ���p.key ���� ������ �˻� ����
				return p.getValue();
			else if (cond < 0)			// key���� �����Ƿ� ���� ���� Ʈ���� �̵�
				p = p.left;
			else
				p = p.right; 			// key���� �����Ƿ� ������ ���� Ʈ���� �̵�
		}
	}

	// node�� ��Ʈ�� �ϴ� ���� Ʈ���� ���<K,V>�� ����
	private void addNode(Node<K, V> node, K key, V data) {
		int cond = comp(key, node.getKey());
		if (cond == 0)							// �̹� ����
			return;
		else if (cond < 0) {					// ����
			if (node.left == null)				// ��������� ����
				node.left = new Node<K, V>(key, data, null, null);
			else								// ���� ���� key ��
				addNode(node.left, key, data);
		} else {								// ����
			if (node.right == null)				// ��������� ����
				node.right = new Node<K, V>(key, data, null, null);
			else								// ���� ���� key ��
				addNode(node.right, key, data);
		}
	}

	// ��� ����
	public void add(K key, V data) {
		if (root == null)
			root = new Node<K, V>(key, data, null, null);
	}

	// End of Document
}
