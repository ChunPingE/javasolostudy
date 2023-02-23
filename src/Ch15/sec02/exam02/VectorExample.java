package Ch15.sec02.exam02;

import java.util.List;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		// Vector 컬렉션 생성
		List<Board> list = new Vector<>();

		// 작업스레드 객체 생성
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				// 객체 1000개추가;
				for (int i = 1; i <= 1000; i++) {
					list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
				}
			}
		});

		// 작업스레드 객체 생성
		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				// 객체 1000개추가;
				for (int i = 1001; i <= 2000; i++) {
					list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
				}
			}
		});

		// 작업스레드 실행
		threadA.start();
		threadB.start();

		// 작업 스레드들이 모두 종료될 때 까지 메인 스레드 기다리기
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
		}
		
		//저장된 총객체수 얻기
		int size = list.size();
		System.out.println("총객체수: " + size);
		System.out.println();
	}
}
