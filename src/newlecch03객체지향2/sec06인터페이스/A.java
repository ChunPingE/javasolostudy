package newlecch03객체지향2.sec06인터페이스;

public class A {
	private X x;
	
	public A () {
		//b = new B();
	}
	
	public void setX(X x) {
		this.x = x;
	}
	
	public void print() {
		int total = x.total();
		System.out.println(total);
	}
}
