package Ch14.sec05.exam02;

public class JoinExample {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();

		sumThread.start();

		System.out.println("1~100합:" + sumThread.getSum()); // 0

		try {
			sumThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~100합:" + sumThread.getSum()); // 5050
	}
}
