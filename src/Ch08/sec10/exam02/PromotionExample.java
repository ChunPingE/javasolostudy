package Ch08.sec10.exam02;

public class PromotionExample {
	public static void main(String[] args) {
		// 인터페이스 변수 선언과 구현객체 선언
		Vehicle vehicle = new Bus();

		// 인터페이스 통해서 호출
		vehicle.run();

		// 강제 타입 변환 후 호출
		Bus bus = (Bus) vehicle;
		bus.run();
		bus.checkFare();
	}
}
