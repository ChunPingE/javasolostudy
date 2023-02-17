package Ch07.sec04.exam02;

public class AirplaneExample{
	public static void main(String[] args) {
		SupersonicAirplane sa = new SupersonicAirplane();
		sa.takeOff();
		sa.fly(); //일반 비행합니다.
		sa.flyMode = SupersonicAirplane.SUPERSONIC; 
		sa.fly(); //초음속 비행합니다.
		sa.flyMode = SupersonicAirplane.NORMAL; 
		sa.fly(); //일반 비행합니다.
		sa.land();
	}
}
