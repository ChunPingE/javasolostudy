package Ch14.sec09.exam03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableSubmitExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// ExecutorService 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		// 계산작업 생성 및 처리 요청
		for (int i = 1; i <= 100; i++) {
			final int idx = i;
			Future<Integer> future = executorService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int j = 1; j <= idx; j++) {
						sum += j;
					}
					Thread thread = Thread.currentThread();
					System.out.printf("[%s] 1~%d 합 계산", thread.getName(), idx);
					return sum;
				}
			});

			int result = future.get();
			System.out.println("\t리턴값: " + result); 
		}
		
		//스레드풀 종료
		executorService.shutdown();
	}
}
