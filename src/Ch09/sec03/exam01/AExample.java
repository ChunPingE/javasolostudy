package Ch09.sec03.exam01;

public class AExample {
	public static void main(String[] args) {
		// B객체 생성 및 인스턴스 필드 및 메소드 사용
		A.B b = new A.B();
		System.out.println(b.field1);
		b.method1();
		
		//b클래스의 정적필드 및 메소드사용
		System.out.println(A.B.field2);
		A.B.method2();
	}
}
