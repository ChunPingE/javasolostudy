package Ch13.sec03.exam01;

public class Box<T> {
	//필드
	private T t;
	
	//Getter메소드 타입이 제네릭
	public T get() {
		return t;
	}
	
	//Setter메소드 매개변수가 제네릭
	public void set(T t) {
		this.t = t;
	}
}
