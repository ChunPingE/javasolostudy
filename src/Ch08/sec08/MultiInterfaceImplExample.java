package Ch08.sec08;

public class MultiInterfaceImplExample {
	public static void main(String[] args) {
		// RemoteControl에 구현객체 대입
		RemoteControl rc = new SmartTelevision();
		//RemoteControl 인터페이스에 선언된 추상메소드만 호출가능
		rc.turnOn();
		rc.turnOff();
		//Searchable에 구현객체 대입
		Searchable searchable = new SmartTelevision();
		//Searchable 인터페이스에 선언된 추상메소드만 호출가능
		searchable.search("https://www.youtube.com");
	}
}
