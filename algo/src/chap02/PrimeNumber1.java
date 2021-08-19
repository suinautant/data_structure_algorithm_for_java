package chap02;

public class PrimeNumber1 {
	public static void main(String[] args) {
		int primeCounter = 0;
		Boolean isPrimeNumber;

		for (int num = 2; num <= 1000; num++) {
			isPrimeNumber = true;

			for (int j = 2; j < num; j++) {
				if (num % j == 0) {
					// 소수 아닐 경우
					isPrimeNumber = false;
					break;
				}
			}

			// 아무것으로도 나누어지지 않으면 i와 j가 같다
			if (isPrimeNumber) {
				System.out.println(num);
				primeCounter++;
			}

		}
		System.out.println("1 - 1000까지 소수 개수는 : " + primeCounter);
	}
}
