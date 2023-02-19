package Ch09.sec05.exam02;

public class A {
	//A의 인스턴스 필드
	String field = "A-field";
	
	//A의 인스턴스 메소드
	void method() {
		System.out.println("A-method");
	}
	
	//인스턴스 멤버 클래스
	class B{
		//B 인스턴스 필드
		String field = "B-field";
		
		//B 인스턴스 메소드
		void method() {
			System.out.println("B-method");
		}
		
		//B인스턴스 메소드
		void print() {
			//B객체의 필드와 메소드 사용
			System.out.println(this.field); //B의 필드
			this.method();  //B의 메소드
			
			//A객체의 필드와 메소드 사용
			System.out.println(A.this.field); //A(바깥)의 필드
			A.this.method();  //A(바깥)의 메소드
		}
		
	}
	
	//A의 인스턴스 메소드
	void useB() {
		B b = new B();
		b.print();
	}
}
