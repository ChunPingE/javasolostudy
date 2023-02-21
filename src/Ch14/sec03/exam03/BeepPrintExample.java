package Ch14.sec03.exam03;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		// 메인스레드 실행시작
		// 작업 스레드에 자식객체 생성
		Thread thread = new Thread() {
			@Override
			public void run() {
				// Toolkit객체 얻기
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {Thread.sleep(500);
					} catch (Exception e) {e.printStackTrace();}
				}
			}
		};

		// 작업 스레드 실행시작(위코드)
		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);
			} catch (Exception e) {e.printStackTrace();}
		}
	}
}
