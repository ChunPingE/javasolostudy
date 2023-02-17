package newlecch06Thread;

public class Ex5Program_join_wating {

	public static void main(String[] args) {
		
		Thread th = Thread.currentThread();
		th.setName("Main");
		
		Runnable subMain = new Runnable() {
			@Override
			public void run() {
				System.out.printf("%s : %s\n", th.getName(), th.getState());
				print();
				System.out.printf("%s : %s\n", th.getName(), th.getState());
			}
		};
		
		Thread th1 = new Thread(subMain);
		th1.setName("sub1");
		
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		
		th1.start();

		if (th1.isAlive()) {
			try {
				th1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("main exit");
	}

	private static void print() {
		for (int i = 0; i < 100; i++) {
			
			Thread th = Thread.currentThread();
			try {
				th.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("%s[%d] : %d\n", th.getName(), th.getId(), i + 1);
		}
	}
}
