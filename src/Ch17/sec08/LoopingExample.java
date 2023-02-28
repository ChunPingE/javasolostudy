package Ch17.sec08;

import java.util.Arrays;

public class LoopingExample {
	public static void main(String[] args) {
		int[] intArr = { 1, 2, 3, 4, 5 };

		// 잘못 작성한 경우
		Arrays.stream(intArr)
				.filter(a -> a % 2 == 0)
				.peek(n -> System.out.println(n));
		// 최종처리가 없으므로 동작하지 않음.

		// 중간처리 메소드 peek()를 이용해서 반복처리
		int total = Arrays.stream(intArr)
				.filter(a -> a % 2 == 0)
				.peek(n -> System.out.println(n))
				.sum();
		System.out.println("총합: " + total + "\n");

		// 최종처리 메소드를 forEach를 이용해서 반복처리
		Arrays.stream(intArr)
				.filter(a -> a % 2 == 0)
				.forEach(n -> System.out.println(n));
	}
}
