package Ch14.sec04;

public class ThreadNameExample {
	public static void main(String[] args) {
		// 메인스레드 객체 얻기
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName() + " 실행");

		for (int i = 0; i < 3; i++) {
			Thread threadA = new Thread() {
				@Override
				public void run() {
					System.out.println(getName() + " 실행");
				}
			};
			threadA.start();
		}

		Thread chatThread = new Thread() {
			@Override
			public void run() {
				System.out.println(getName() + " 실행");
			}
		};
		chatThread.setName("chat-thread");
		chatThread.start();
	
		/*
		Thread chatThread2 = new Thread(() ->{
			Thread td = Thread.currentThread();
			System.out.println(td.getName() + " 실행");
		});
		chatThread2.setName("chat-thread2");
		chatThread2.start();
		*/
	}
}
