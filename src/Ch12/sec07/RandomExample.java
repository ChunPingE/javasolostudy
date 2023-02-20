package Ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
	public static void main(String[] args) {
		// 선택번호
		int[] selectNumber = new int[6]; // 선택번호 6개가저장될 배열생성
		Random random = new Random(3); // 선택번호를 얻기위한 Random 객체 생성
	
		System.out.print("선택번호: ");
		for (int i = 0 ; i < 6 ; i++) {
			//선택번호 6개를 얻어 배열에 저장
			selectNumber[i] = random.nextInt(45)+1;
			System.out.print(selectNumber[i]+ " ");
		}
		System.out.println();
		
		//당첨번호
		int[] winningNumber = new int[6]; // 선택번호 6개가저장될 배열생성
		random = new Random(5); // 선택번호를 얻기위한 Random 객체 생성
		
		System.out.print("당첨번호: ");
		for (int i = 0 ; i < 6 ; i++) {
			//선택번호 6개를 얻어 배열에 저장
			selectNumber[i] = random.nextInt(45)+1;
			System.out.print(selectNumber[i]+ " ");
		}
		System.out.println();

		//당첨여부
		Arrays.sort(selectNumber); //비교하기전 배열항목을 정렬
		Arrays.sort(winningNumber);
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.print("당첨여부: ");
		if(result) {
			System.out.println("1등에 당첨되셨습니다.");
		} else {
			System.out.println("당첨되지 않았습니다.");
		}
	}
}
