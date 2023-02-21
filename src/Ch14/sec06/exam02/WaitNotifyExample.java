package Ch14.sec06.exam02;

public class WaitNotifyExample {
	public static void main(String[] args) {
		//공유할 작업객체
		WorkObject workObject = new WorkObject();
		
		ThreadA threadA = new ThreadA(workObject);
		ThreadB threadB = new ThreadB(workObject);
		
		threadA.start();
		threadB.start();
	}
}
