package Ch16.sec02.exam02;

import Ch09.sec07.exam03.Button;

public class ButtonExample {
	public static void main(String[] args) {
		// ok버튼 객체 생성
		Button btnOk = new Button();

		//ok버튼에 익명 구현객체 주입
		btnOk.setClickListener(() -> {
			System.out.println("Ok 버튼을 클릭했습니다.");
		});

		// Ok버튼 클릭
		btnOk.click(); // Ok 버튼을 클릭했습니다.

		// ------------------------------------------

		// Cancel 버튼
		// ok버튼 객체 생성
		Button btnCancel = new Button();

		btnCancel.setClickListener(()->{
			System.out.println("Cancel 버튼을 클릭했습니다.");
		});


		// Ok버튼 클릭
		btnCancel.click(); // Cancel 버튼을 클릭했습니다.
	}
}
