package Ch07.sec10.exam01;

public abstract class Phone {
	// 필드선언
	String owner;

	//기본생성자 선언
	Phone(String owner) {
		this.owner = owner;
	}
	
	//메소드 선언
	void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}
	//메소드 선언
	void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
}
