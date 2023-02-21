package newlecch06Thread.part2;

import java.sql.Timestamp;

public class Ex5Program_multi_critical_section {

	public static void main(String[] args) {

		Timestamp time1 = new Timestamp(System.currentTimeMillis());
		CharList3 list = new CharList3();

		Runnable subLoad = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 80; i++) {
					list.load();
				}
			}
		};

		Runnable subprintAll = new Runnable() {
			@Override
			public void run() {
				list.printAll(100);
			}
		};

		Thread th1 = new Thread(subLoad);
		th1.setName("sub1");
		Thread th2 = new Thread(subprintAll);
		th2.setName("sub2");
		Thread th3 = new Thread(subprintAll);
		th3.setName("sub3");

		th1.start();
		th2.start();
		//th3.start();

		// print();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 메인스레드가 다른애들 끝나는걸 기다림
		try {
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Timestamp time2 = new Timestamp(System.currentTimeMillis());
		System.out.println(time2.getTime() - time1.getTime());

		System.out.println("==main exit===");
	}

	static Object lockIndex = new Object();
	static int gIndex = 0; // 데이터/정적 모든스레드가 공유

}
