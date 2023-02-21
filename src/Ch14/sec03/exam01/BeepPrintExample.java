package Ch14.sec03.exam01;

import java.awt.Toolkit;

public class BeepPrintExample {
	public static void main(String[] args) {
		// Toolkit객체 얻기
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				// 0.5초간 정지
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				// 0.5초간 정지
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
