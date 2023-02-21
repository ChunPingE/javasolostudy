package Ch14.sec05.exam03;

public class YieldExample {
	public static void main(String[] args) {
		WorkThread wokrThreadA = new WorkThread("wokrThreadA");
		WorkThread wokrThreadB = new WorkThread("wokrThreadB");
		wokrThreadA.start();
		wokrThreadB.start();

		try {Thread.sleep(5000);
		} catch (InterruptedException e) {e.printStackTrace();}
	
		wokrThreadA.work = false;
		
		try {Thread.sleep(10000);
		} catch (InterruptedException e) {e.printStackTrace();}
	
		wokrThreadA.work = true;
	}
}
