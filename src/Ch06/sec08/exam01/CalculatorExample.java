package Ch06.sec08.exam01;

public class CalculatorExample {
	public static void main(String[] args) {
		// 객체생성
		Calculator myCalc = new Calculator();

		// 리턴값이 없는 powerOn() 메소드 호출
		myCalc.powerOn(); // 전원을 켭니다.

		// plus() 메소드호출 5,6 매개값제공 덧셈결과 리턴받아 변수에대입
		int result1 = myCalc.plus(5, 6);
		System.out.println("result1: " + result1); // 11

		int x = 10;
		int y = 4;
		// divie()메소드 호출 x,y를 매개값제공 리턴값을 대입
		double result2 = myCalc.divide(x, y);
		System.out.println("result2: " + result2); // 2.5

		// 리턴값이 없는 powerOff() 메소드 호출
		myCalc.powerOff(); // 전원을 끕니다.
	}
}
