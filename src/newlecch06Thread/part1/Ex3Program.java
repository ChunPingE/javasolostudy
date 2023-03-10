package newlecch06Thread.part1;

public class Ex3Program {

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
		
		th1.start();
		th2.start();

		Thread th = Thread.currentThread();
		th.setName("MAIN");
		print();
	}

	private static void print() {
		for (int i = 0; i < 100; i++) {
			
			Thread th = Thread.currentThread();
			System.out.printf("%s[%d] : %d\n", th.getName(), th.getId(), i + 1);
		}
	}
}
