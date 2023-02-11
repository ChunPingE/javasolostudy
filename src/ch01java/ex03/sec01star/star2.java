package ch01java.ex03.sec01star;

public class star2 {

	public static void main(String[] args) {
		for (int i = 0 ; i <10; i++) {
			for (int j = 0 ; j <= i; j++) {
				System.out.printf("%c", '☆');
			}
			System.out.println();
		}

	}

}
