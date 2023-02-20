package Ch12.sec06;

public class BoxingUnBoxingExample {
	public static void main(String[] args) {
		//Boxing
		Integer obj = 100;
		System.out.println("value: " + obj.intValue()); //value: 100
		
		//Unboxing
		int value = obj;
		System.out.println("value: " + value); //value: 100
		
		//연산 시 Unboxing
		int result = obj + 100;
		System.out.println("result: " + result); //result: 200
	}
}
