package Ch08.sec12;

public class InstanceofExample {
	public static void main(String[] args) {
		// 구현객체 생성
		Taxi taxi = new Taxi();
		Bus bus = new Bus();

		// ride() 메소드 호출시 구현객체를 매개값으로 전달.
		ride(taxi); //택시가 달립니다.

		System.out.println();
		ride(bus); // 승차요금을 체크합니다. / 버스가 달립니다.
	}

	// 인터페이스를 매개변수로 갖는 메소드
	public static void ride(Vehicle vehicle) {
		/*
		 * if(vehicle instanceof bus) { Bus bus = (Bus) vehicle; bus.checkFare(); }
		 */
		// 자바 12부터 사용가능
		if (vehicle instanceof Bus bus) {
			bus.checkFare();
		}
		vehicle.run();
	}
}
