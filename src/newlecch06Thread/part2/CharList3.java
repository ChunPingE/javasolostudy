package newlecch06Thread.part2;

import java.util.concurrent.locks.ReentrantLock;

public class CharList3 {
	private char[] list;
	private int index;
	private ReentrantLock indexLock;

	public CharList3() {
		indexLock = new ReentrantLock();
		list = new char[240];
		index = 0;
	}

	public void load(){
		for (int i = 0; i < 26; i++) {

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			list[i] = (char) ('A' + i);
		}
	}

	public void printAll(int count) {

		Thread th = Thread.currentThread();

		for (int i = 0; i < count; i++) {
			StringBuilder bu = new StringBuilder();
			bu.append(list);

			System.out.printf("%s[%d-%d] : %s\n", th.getName(), th.getId(), ++index, bu.toString());
		}
	}

	public void printNext() {
		char ch = list[index];

		Thread th = Thread.currentThread();

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			return;
		}

		boolean aquired = indexLock.tryLock();

		if (aquired) {
			// indexLock.lock();
			// synchronized (indexLock) {
			System.out.printf("%s[%d] : index:%d, char:%c\n", th.getName(), th.getId(), index, list[index]);
			index++;
			// }
			indexLock.unlock();
		} else {
			System.out.printf("%s[%d] : alternate\n", th.getName(), th.getId());
		}
	}
}
