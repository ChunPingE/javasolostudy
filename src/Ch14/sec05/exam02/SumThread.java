package Ch14.sec05.exam02;

public class SumThread extends Thread {
	private long sum;

	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}
	
	@Override
	public void run() {
		/*
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		*/
		//sum = n *(시작항 + 마지막항)/2
		sum = 100 * (100+1) / 2; 
	}
}
