package Ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
	public static int sum;

	public static void main(String[] args) {

		long start1 = System.nanoTime();
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println("총합: " + sum);
		long end1 = System.nanoTime();
		System.out.println("1:" + (end1 - start1));

		long start2 = System.nanoTime();
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		long end2 = System.nanoTime();
		System.out.println("2:" + (end2 - start2));
	}
}
