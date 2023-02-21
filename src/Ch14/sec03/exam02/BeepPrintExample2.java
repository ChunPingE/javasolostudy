package Ch14.sec03.exam02;

public class BeepPrintExample2 {
	public static void main(String[] args) {
		// 메인스레드 실행시작
		Thread thread = new Thread(new Task());

		// 작업 스레드 실행시작(위코드)
		thread.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {Thread.sleep(500);
			} catch (Exception e) {e.printStackTrace();}
		}
	}
}
