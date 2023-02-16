package Ch06.sec07.exam02;

public class KoreanExample {
	public static void main(String[] args) {
		// Korean 객체 생성
		Korean k1 = new Korean("박자바", "011225-1234567");
		// Korean객체 데이터 읽기
		System.out.println("k1.nation : " + k1.nation); //대한민국
		System.out.println("k1.name : " + k1.name); //박자바
		System.out.println("k1.ssn : " + k1.ssn); //011225-1234567
		System.out.println();

		// Korean 객체 생성
		Korean k2 = new Korean("김자바", "930525-0654321");
		// 또 다른 Korean객체 데이터 읽기
		System.out.println("k2.nation : " + k2.nation); //대한민국
		System.out.println("k2.name : " + k2.name); //김자바
		System.out.println("k2.ssn : " + k2.ssn); //930525-0654321
		System.out.println();
	}
}
