package ch03객체지향.sec06인터페이스;

public class A {
	private B b;
	
	public A() {
		b = new B();
	}

	public void print() {
		int total = b.total();
		System.out.println(total);
	}
}
