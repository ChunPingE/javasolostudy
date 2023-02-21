package Ch12.sec07;

public class MathExample {
	public static void main(String[] args) {
		//큰 점수 또는 작은 점수 얻기
		double v1 = Math.ceil(5.3); //올림
		double v2 = Math.floor(5.3); //내림
		System.out.println("v1= " + v1); // 6.0
		System.out.println("v2= " + v2); //5.0

		//큰값 또는 작은 값 얻기
		long v3 = Math.max(3, 7);
		long v4 = Math.min(3, 7);
		System.out.println("v3= " + v3); //7
		System.out.println("v4= " + v4); //3
		
		//소수 이하 두 자리 얻기
		double value = 12.3456;
		double temp1 = value * 100;
		long temp2 = Math.round(temp1); //반올림
		double v5 = temp2 / 100.0;
		System.out.println("v5= " + v5); //12.35
	}
}