package chap02;

public class PrimeNumber1 {
	public static void main(String[] args) {
		int primeCounter = 0;
		Boolean isPrimeNumber;

		for (int num = 2; num <= 1000; num++) {
			isPrimeNumber = true;

			for (int j = 2; j < num; j++) {
				if (num % j == 0) {
					// �Ҽ� �ƴ� ���
					isPrimeNumber = false;
					break;
				}
			}

			// �ƹ������ε� ���������� ������ i�� j�� ����
			if (isPrimeNumber) {
				System.out.println(num);
				primeCounter++;
			}

		}
		System.out.println("1 - 1000���� �Ҽ� ������ : " + primeCounter);
	}
}
