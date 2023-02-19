package Ch09.sec06.exam03;

public class ButtonExample {
	public static void main(String[] args) {
		// ok버튼 객체 생성
		Button btnOk = new Button();

		// Ok버튼 클릭 이벤트를 처리할 ClickListener 구현클래스(로컬 클래스)
		class OkListener implements Button.ClickListener {
			// 정적인터페이스라 바깥클래스.인터페이스
			@Override
			public void onClick() {
				System.out.println("Ok 버튼을 클릭했습니다.");
			}
		}

		// Ok버튼 객체에 ClickListener 구현객체 주입
		btnOk.setClickListener(new OkListener());

		// Ok버튼 클릭
		btnOk.click(); // Ok 버튼을 클릭했습니다.

		// ------------------------------------------

		// Cancel 버튼
		// ok버튼 객체 생성
		Button btnCancel = new Button();

		// Ok버튼 클릭 이벤트를 처리할 ClickListener 구현클래스(로컬 클래스)
		class CancelListener implements Button.ClickListener {
			// 정적인터페이스라 바깥클래스.인터페이스
			@Override
			public void onClick() {
				System.out.println("Cancel 버튼을 클릭했습니다.");
			}
		}

		// Ok버튼 객체에 ClickListener 구현객체 주입
		btnCancel.setClickListener(new CancelListener());

		// Ok버튼 클릭
		btnCancel.click(); // Cancel 버튼을 클릭했습니다.
	}
}
