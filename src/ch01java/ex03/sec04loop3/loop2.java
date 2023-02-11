package ch01java.ex03.sec04loop3;

public class loop2 {

	public static void main(String[] args) {

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				System.out.printf("%d", (y * 3) + x + 1);
			}
			System.out.println();
		}

	}

}
