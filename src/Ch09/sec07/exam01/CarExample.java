package Ch09.sec07.exam01;

public class CarExample {
	public static void main(String[] args) {
		// 객체생성
		Car car = new Car();

		// 필드에 익명 자식객체가 대입된 메소드 사용
		car.run1();
		//tire1.roll(); 일반 타이어가 굴러갑니다.
		//tire2.roll(); 익명 자식 Tire 객체 1이 굴러갑니다.

		// 로컬 변수에 익명자식객체가 대입된 메소드 사용
		car.run2(); //tire.roll(); 익명 자식객체 Tire 객체2가 굴러갑니다.

		// 매개변수에 익명자식객체가 대입되는 메소드 사용
		car.run3(new Tire() {
			@Override
			public void roll() {
				System.out.println("익명 자식 Tire 객체 3이 굴러갑니다.");
			}
		});
		//익명 자식 Tire 객체 3이 굴러갑니다.
	}
}
