package Ch06.sec08.exam02;

public class ComputerExample {
	public static void main(String[] args) {
		// 객체생성
		Computer myCom = new Computer();

		// sum() 메소드 호출 시 매개값 1,2,3제공
		int result1 = myCom.sum(1, 2, 3);
		System.out.println("result1: " + result1); //6

		// 1,2,3,4,5 매개값제공
		int result2 = myCom.sum(1, 2, 3, 4, 5);
		System.out.println("result2: " + result2); //15

		// 배열 제공
		int[] values = { 1, 2, 3, 4, 5 };
		int result3 = myCom.sum(values);
		System.out.println("result3: " + result3); //15
		
		//생성자에 직접 배열생성해서 제공
		int result4 = myCom.sum(new int[] { 1, 2, 3, 4, 5 });
		System.out.println("result4: " + result4); //15
	}
}
