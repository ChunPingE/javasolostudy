package newlecch06Thread.part2;

public class Ex2Program_monitor_critical_section {

	public static void main(String[] args) {

		Runnable subMain = new Runnable() {
			@Override
			public void run() {
				print();
			}
		};

		Thread th1 = new Thread(subMain);
		th1.setName("sub1");
		Thread th2 = new Thread(subMain);
		th2.setName("sub2");
		Thread th3 = new Thread(subMain);
		th3.setName("sub3");

		th1.start();
		th2.start();
		th3.start();

		Thread th = Thread.currentThread();
		th.setName("MAIN");
		// print();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("==main exit===");
	}

	static Object lockIndex = new Object();
	static int gIndex = 0; // 데이터/정적 모든스레드가 공유

	private static void print() {

		int index = 0; // 스택 스레드별로

		Thread th = Thread.currentThread();
		for (int i = 0; i < 100; i++) {

			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}
			// lock로 잠금을 해야하는 상황
			synchronized (lockIndex) {
				
				index++;
				gIndex++;

				System.out.printf("%s[%d] : %d, index: %d, gIndex: %d\n", th.getName(), th.getId(), i + 1, index,
						gIndex);
			}

		}
	}
}
