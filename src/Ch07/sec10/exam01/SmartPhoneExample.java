package Ch07.sec10.exam01;

public class SmartPhoneExample{
	public static void main(String[] args) {
		
		//Phone phone = new Phone(); 불가능
		
		//smartphone객체 생성
		SmartPhone smarthPhone = new SmartPhone("홍길동"); 
		
		smarthPhone.turnOn();
		smarthPhone.internetSearch();
		smarthPhone.turnOff();
	}
}
