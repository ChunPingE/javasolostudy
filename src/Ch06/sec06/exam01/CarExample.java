package Ch06.sec06.exam01;

public class CarExample {

	public static void main(String[] args) {
		// Car객체 생성
		Car myCar = new Car();

		// Car객체의 필드값 읽기
		System.out.println("제작회사: " + myCar.company); // 현대자동차
		System.out.println("모델명: " + myCar.model); // 그랜져
		System.out.println("색깔: " + myCar.color); // 검정
		System.out.println("최고속도: " + myCar.maxSpeed); // 350
		System.out.println("현재속도: " + myCar.speed); // 0

		// Car 객체의 필드값 변경
		myCar.speed = 60;
		System.out.println("현재속도: " + myCar.speed); // 60

	}

}
