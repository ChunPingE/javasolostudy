package Ch16.sec04;

public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();

		// 실행문이 두개 이상
		person.action((x, y) -> {
			double result = x + y;
			return result;
		});

		// 리턴문이 하나만 잇을경우(연산식)
		person.action((x, y) -> {
			return x + y;
		});

		person.action((x, y) -> (x + y));

		// 리턴문이 하나만 잇을경우 메소드 호출
		person.action((x, y) -> {
			return sum(x, y);
		});

		person.action((x, y) -> sum(x, y));
		
		//dd?
		person.action(LambdaExample :: sum);
	}

	public static double sum(double x, double y) {
		return (x + y);
	}
}
