package chap04;

public class IntQueue {
	private int max; // 큐의 용량
	private int front; // 첫 번째 요소 커서
	private int rear; // 마지막 요소 커서
	private int num; // 현재 데이터 수
	private int[] que; // 큐 본체

	// 실행 시 예외 : 큐가 비어 있음
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	// 실행 시 예외 : 큐가 가득
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}

	// 생성자
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// 큐 인큐(enqueue)
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= max)
			throw new OverflowIntQueueException();
		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;
		return x;
	}

	// 큐 디큐 (dequeue)
	public int deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	// 디큐 가능한 값 확인 (커서 이동 없음)
	public int peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		return que[front];
	}

	// 큐 검색, 성공시 인덱스 반환, 실패시 -1 반환
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x)
				return que[idx];
		}
		return -1;
	}

	// 배열의 인덱스가 아닌 몇 번째에 위치하고 있는지 반환
	// 없으면 0, 있으면 1부터 위치 반환
	public int search(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x)
				return i + 1;
		}
		return 0;
	}

	// 큐 비움
	public void clear() {
		num = front = rear = 0;
	}

	// 큐 용량 확인
	public int capacity() {
		return max;
	}

	// 큐에 쌓여 있는 데이터 수 확인
	public int size() {
		return num;
	}

	// 큐 비어 있는지 여부
	public boolean isEmpty() {
		return num <= 0;
	}

	// 큐 가득 찼는지 여부
	public boolean isFull() {
		return num >= max;
	}

	// 큐 안의 모든 데이터를 입력 순서로 출력
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어 있습니다.");
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
