package Ch14.sec06.exam01;

public class User2Thread extends Thread{
	private Calculator calculator;
	
	public User2Thread() {
		setName("User2Thread");
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		//동기화 메소드 호출
		calculator.setMemory2(50);
	}
}
