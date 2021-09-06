package chap07;

public class IntSet {
	private int max; // 배열 최대 값
	private int num; // 요소 수
	private int[] set; // 배열

	// 생성자
	public IntSet(int capacity) {
		max = capacity;
		num = 0;
		try {
			set = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return num;
	}

	// 값이 있으면 index 반환
	// 없으면 -1 반환
	public int indexOf(int n) {
		for (int i = 0; i < num; i++)
			if (set[i] == n)
				return i;
		return -1;
	}

	// 값을 포함하고 있는지 여부
	public boolean contains(int n) {
		return (indexOf(n) != -1) ? true : false;
	}

	// 배열에 값 추가
	public boolean add(int n) {
		if (num >= max || contains(n) == true)
			return false;
		else {
			set[num++] = n;
			return true;
		}
	}

	// 값 삭제
	public boolean remove(int n) {
		int idx;
		if (num <= 0 || (idx = indexOf(n)) == -1)
			return false;
		else {
			set[idx] = set[--num];
			return true;
		}
	}

	// s배열에 값 복사
	// 작은 배열의 크기만큼 복사
	public void copyTo(IntSet s) {
		int n = (s.max < num) ? s.max : num;
		for (int i = 0; i < n; i++)
			s.set[i] = set[i];
		s.num = n;
	}

	// s배열로부터 값 복사
	// 작은 배열의 크기만큼 복사
	public void copyFrom(IntSet s) {
		int n = (max < s.num) ? max : s.num;
		for (int i = 0; i < n; i++)
			set[i] = s.set[i];
		num = n;
	}

	// 인자 s와 같은지 확인
	public boolean equalTo(IntSet s) {
		// 요소수가 다름
		if (num != s.num)
			return false;
		// 값 비교
		for (int i = 0; i < num; i++) {
			int j = 0;
			// 값 확인
			for (; j < s.num; j++)
				// s의 값과 같은지 비교
				if (set[i] == s.set[j])
					break;
			// 요소수 만큼 같은 값을 찾지 못하면 다른 집합
			if (j == s.num)
				return false;
		}
		return true;
	}

	// s1과 s2 배열 통합
	public void unionOf(IntSet s1, IntSet s2) {
		// s1으로부터 복사
		copyFrom(s1);
		// s1으로부터 복사 한 지점 이후 s2 add()
		for (int i = 0; i < s2.num; i++) {
			add(s2.set[i]);
		}
	}

	// 문자화
	public String toString() {
		StringBuffer temp = new StringBuffer("{ ");
		for (int i = 0; i < num; i++)
			temp.append(set[i] + " ");
		temp.append("}");
		return temp.toString();
	}

	// 비었는지 확인
	public boolean isEmpty() {
		return (num == 0) ? true : false;
	}

	// 가득 찼는지 확인
	public boolean isFull() {
		return (num == max) ? true : false;
	}

	// 배열 요소 전체 삭제
	public void clear() {
		for (int i = max - 1; i >= 0; i--) {
			remove(set[i]);
		}
	}

}
