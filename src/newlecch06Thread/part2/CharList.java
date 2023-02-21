package newlecch06Thread.part2;

public class CharList {
	private char[] list;
	private int index;

	public CharList() {
		// 80번 도는데 3개 스레드 돌릴거니 240개
		list = new char[240];
		for (int i = 0; i < 240; i++) {
			list[i] = (char) i;
		}
		index = 0;
	}

	public void printNext() {
		char ch = list[index];

		Thread th = Thread.currentThread();

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			return;
		}

		synchronized (this) {
		System.out.printf("%s[%d] : index:%d, char:%c\n", th.getName(), th.getId(), index, list[index]);
		index++;
		}
	}
}
