package Ch09.sec07.exam02;

public class HomeExample {
	public static void main(String[] args) {
		// Home 객체 생성
		Home home = new Home();

		// 필드에 익명구현객체가 대입된 메소드 사용
		home.use1();

		// 로컬변수에 익명구현객체가 대입된 메소드 사용
		home.use2();

		// 매개변수에 익명구현객체를 대입해 메소드 사용
		// home.use3(new RemoteControl() {});
		home.use3(new RemoteControl() {

			@Override
			public void turnOn() {
				System.out.println("난방을 켭니다.");
			}

			@Override
			public void turnOff() {
				System.out.println("난방을 끕니다.");
			}
		});
	}
}
