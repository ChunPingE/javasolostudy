package newlecch06Thread;

public class Ex4Program {

	public static void main(String[] args) {
		
		Runnable subMain = new Runnable() {
			@Override
			public void run() {
				print();
			}
		};
		
		Thread th1 = new Thread(subMain);
		th1.setName("sub1");
		
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		
		th1.start();

		Thread th = Thread.currentThread();
		th.setName("MAIN");
		print();
		
		System.out.printf("%s : %s\n", th1.getName(), th1.getState());
		
		System.out.println("main exit");
	}

	private static void print() {
		for (int i = 0; i < 100; i++) {
			
			Thread th = Thread.currentThread();
			try {
				th.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("%s[%d] : %d\n", th.getName(), th.getId(), i + 1);
		}
	}
}
