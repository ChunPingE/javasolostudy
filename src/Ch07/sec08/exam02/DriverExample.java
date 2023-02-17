package Ch07.sec08.exam02;

public class DriverExample {
	public static void main(String[] args) {
		//Driver 객체 생성
		Driver driver = new Driver();
		
		//매개변수로 Bus객체를 제공하고 driver 메소드 호출
		Bus bus = new Bus();
		driver.drive(bus); //버스가 달립니다.
		
		//매개변수로 Taxi객체를 제공하고 driver 메소드 호출
		Taxi taxi = new Taxi();
		driver.drive(taxi); //택시가 달립니다.
	}
}
