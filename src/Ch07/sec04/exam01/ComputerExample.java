package Ch07.sec04.exam01;

public class ComputerExample {
	public static void main(String[] args) {
		int r = 10;
		
		Calculator calc = new Calculator();
		System.out.println("원 면적: " + calc.areaCircle(r)); //314.159
		System.out.println(); 
		
		Computer com = new Computer();
		System.out.println("원 면적: " + com.areaCircle(r)); //314.1592653589793
	}
}
