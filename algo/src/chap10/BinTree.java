package chap10;

import java.util.Comparator;

public class BinTree<K, V> {
	// 노드
	static class Node<K, V> {
		private K key;				// 키 값
		private V data;				// 데이터
		private Node<K, V> left;	// 왼쪽 자식 노드
		private Node<K, V> right;	// 오른쪽 자식 노드

		// 생성자
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

	// 비어있는 이진검색트리 생성
	// 자연 순선에 따라 대소 관계 판단
	// Comparable : Integer, String 사용
	// comparator 필드 : null
	public BinTree() {
		root = null;
	}

	// 비어있는 이진검색트리 생성
	// 비교자로 대소 관계 판단
	// Comparator
	public BinTree(Comparator<? super K> comparator) {
		this();
		this.comparator = comparator;
	}

	// 비교
	// BinTree()를 통해 생성하면 Comparable.compareTo 이용해 비교
	// comprator 값 있으면 Comparator.compare 이용해 비교
	// key1 > key2 : 1
	// key1 == key2 : 0
	// key1 < key2 : -1
	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
	}

	// 키 검색
	public V search(K key) {
		Node<K, V> p = root;

		while (true) {
			if (p == null)				// p 값 없으면  검색 실패
				return null;
			int cond = comp(key, p.getKey());
			if (cond == 0)				// key와 노드p.key 값이 같으면 검색 성공
				return p.getValue();
			else if (cond < 0)			// key값이 작으므로 왼쪽 서브 트리로 이동
				p = p.left;
			else
				p = p.right; 			// key값이 작으므로 오른쪽 서브 트리로 이동
		}
	}

	// node를 루트로 하는 서브 트리에 노드<K,V>를 삽입
	private void addNode(Node<K, V> node, K key, V data) {
		int cond = comp(key, node.getKey());
		if (cond == 0)							// 이미 있음
			return;
		else if (cond < 0) {					// 좌측
			if (node.left == null)				// 비어있으면 삽입
				node.left = new Node<K, V>(key, data, null, null);
			else								// 좌측 노드와 key 비교
				addNode(node.left, key, data);
		} else {								// 우측
			if (node.right == null)				// 비어있으면 삽입
				node.right = new Node<K, V>(key, data, null, null);
			else								// 우측 노드와 key 비교
				addNode(node.right, key, data);
		}
	}

	// 노드 삽입
	public void add(K key, V data) {
		if (root == null)
			root = new Node<K, V>(key, data, null, null);
	}

	// End of Document
}
