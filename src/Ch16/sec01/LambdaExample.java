package Ch16.sec01;

public class LambdaExample {
	public static void main(String[] args) {
		action((x, y) -> {
			int result = x + y;
			System.out.println(result);
		});

		action((x, y) -> {
			int result = x - y;
			System.out.println(result);
		});

	}

	public static void action(Calculable calculable) {
		// 데이터
		int x = 10;
		int y = 4;
		// 데이터처리
		calculable.calculate(x, y);
	}
}
