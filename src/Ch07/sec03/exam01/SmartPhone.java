package Ch07.sec03.exam01;

public class SmartPhone extends Phone{
	//필드선언
	public boolean wifi;
	
	//생성자 선언
	public SmartPhone(String model, String color) {
		super(); //생략가능 컴파일시 자동추가됨
		this.model = model; 
		this.color = color; 
	}
}
