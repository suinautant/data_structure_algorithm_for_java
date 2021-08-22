package chap05;

// int 형 스택 
public class IntStack {
	private int max; // 스택 용량
	private int ptr; // 스택 포인터 (현재 저장할 수 있는 위치)
	private int[] stk; // 스택 본체

	// 실행 시 예외 : 스택이 비어 있음
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// 실행 시 예외 : 스택이 가득 참
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// 생성자
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// 스텍 푸시 구현
	// 포인터 위치에 값 저장 후 포인터 위치 값 1증가
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= max)
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

	// 스택 팝 구현
	// ptr 위치 이동 후 값 리턴
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	// 포인터 이동 없이 값만 확인
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	// 스택 검색, 성공시 인덱스 반환, 실패시 -1 반환
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--)
			// 값을 찾을 경우 해당 인덱스 반환
			if (stk[i] == x)
				return i;
		// 값이 없을 경우 -1 반환
		return -1;
	}

	// 스택 비움
	public void clear() {
		ptr = 0;
	}

	// 스택 용량 반환
	public int capacity() {
		return max;
	}

	// 스택에 쌓여 있는 데이터 수를 반환
	public int size() {
		return ptr;
	}

	// 스택 비어 있는지 여부 확인
	public boolean isEmpty() {
		return ptr <= 0;
	}

	// 스택이 가득 찼는가?
	public boolean isFull() {
		return ptr >= max;
	}

	// 스택 안의 모든 데이터를 바닥에서 꼭대기 순서로 출력
	public void dump() {
		if (ptr <= 0)
			System.out.println("스택이 비어 있습니다.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}

}
