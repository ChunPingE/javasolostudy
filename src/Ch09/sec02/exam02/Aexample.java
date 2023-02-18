package Ch09.sec02.exam02;

public class Aexample {
	public static void main(String[] args) {
		// A객체 생성
		A a = new A();
		
		//A인스턴스 메소드 호출
		a.useB();
		
		//A를통해서B의 정적필드 메소드 사용
		A.B.field2 = 1; 
		A.B.method2();
	}
}
