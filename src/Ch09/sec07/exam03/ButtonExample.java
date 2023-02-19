package Ch09.sec07.exam03;

public class ButtonExample {
	public static void main(String[] args) {
		// ok버튼 객체 생성
		Button btnOk = new Button();

		// Ok버튼 객체에 ClickListener 익명구현객체 주입
		btnOk.setClickListener(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		});

		// Ok버튼 클릭
		btnOk.click(); // Ok 버튼을 클릭했습니다.

		// ------------------------------------------

		// Cancel 버튼
		// ok버튼 객체 생성
		Button btnCancel = new Button();

		// Ok버튼 객체에 ClickListener 익명구현객체 주입
		btnCancel.setClickListener(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다.");
			}
		});

		// Ok버튼 클릭
		btnCancel.click(); // Cancel 버튼을 클릭했습니다.
	}
}
