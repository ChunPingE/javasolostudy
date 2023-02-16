package newlecch01java.ex02.sec14.array;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int kor1, kor2, kor3;
		int[] kors = new int[3];
		int total;
		float avg;
		int menu;

		Scanner sc = new Scanner(System.in);

		kor1 = 50;
		kor2 = 60;
		kor3 = 80;
		
		for(int i = 0 ; i <3; i++) {
			kors[i] = 0;
		}
		
		exit: 
		while (true) {
			// -------메인메뉴-----------------------------
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          메인메뉴        │");
			System.out.println("└──────────────────────────┘");

			System.out.println("\t1. 성적 입력");
			System.out.println("\t2. 성적 출력");
			System.out.println("\t3. 종료");
			System.out.print("\t선택>");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				// -------성적입력부분------------------------------
				System.out.println("┌──────────────────────────┐");
				System.out.println("│          성적입력        │");
				System.out.println("└──────────────────────────┘");
				
				for(int i = 0 ; i <3; i++) {
					do {
						System.out.printf("국어%d:" , i+1);
						kors[i] = sc.nextInt();
						if (kors[i] < 0 || kors[i] > 100) {
							System.out.println("성적 범위(0~100)을 벗어낫습니다.");
						}
					} while (kors[i] < 0 || kors[i] > 100);
				}
				break;
				
				
				
			case 2:
				// -------성적출력부분------------------------------

				total = kor1 + kor2 + kor3;
				avg = total / 3.0f;

				System.out.println("┌──────────────────────────┐");
				System.out.println("│          성적출력        │");
				System.out.println("└──────────────────────────┘");

				
				for(int i = 0 ; i <3; i++) {
					System.out.printf("\t국어%d : %3d\n", i+1 , kors[i]);
				}

				System.out.printf("\t총점 : %3d\n", total);
				System.out.printf("\t평균 : %6.2f\n", avg);
				System.out.println("──────────────────────────");
				break;
			case 3:
				break exit;
			case 4:
				System.out.println("입력오류 1~3번만 입력 할 수 있습니다.");
				break;
			}

		}
		System.out.println("good bye~");

	}

}
