package ch01java.ex02.sec11.ifex;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int kor1, kor2, kor3;
		int total;
		float avg;
		int menu; 

		Scanner sc = new Scanner(System.in);

		kor1 = 50;
		kor2 = 60;
		kor3 = 80;

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
			
			if (menu == 1) {
				// -------성적입력부분------------------------------
				System.out.println("┌──────────────────────────┐");
				System.out.println("│          성적입력        │");
				System.out.println("└──────────────────────────┘");
				
				System.out.print("국어1:");
				kor1 = sc.nextInt();

				do {
					System.out.print("국어1:");
					kor1 = sc.nextInt();
					if (kor1 < 0 || kor1 > 100) {
						System.out.println("성적 범위(0~100)을 벗어낫습니다.");
					}
				} while(kor1 < 0 || kor1 > 100);
				
				do {
					System.out.print("국어2:");
					kor2 = sc.nextInt();
					if (kor2 < 0 || kor2 > 100) {
						System.out.println("성적 범위(0~100)을 벗어낫습니다.");
					}
				} while(kor2 < 0 || kor2 > 100);

				do {
					System.out.print("국어3:");
					kor3 = sc.nextInt();
					if (kor3 < 0 || kor3 > 100) {
						System.out.println("성적 범위(0~100)을 벗어낫습니다.");
					}
				} while(kor3 < 0 || kor3 > 100);
				
			} else if (menu == 2) {
				// -------성적출력부분------------------------------

				total = kor1 + kor2 + kor3;
				avg = total / 3.0f;

				System.out.println("┌──────────────────────────┐");
				System.out.println("│          성적출력        │");
				System.out.println("└──────────────────────────┘");

				System.out.printf("\t국어1 : %3d\n", kor1);
				System.out.printf("\t국어2 : %3d\n", kor2);
				System.out.printf("\t국어3 : %3d\n", kor3);
				
				System.out.printf("\t총점 : %3d\n", total);
				System.out.printf("\t평균 : %6.2f\n", avg);
				System.out.println("──────────────────────────");
			} else if (menu == 3) {
				//System.exit(0);
				break;
			} else {
				System.out.println("입력오류 1~3번만 입력 할 수 있습니다.");
			}
		
				
		}
		System.out.println("good bye~");
			
			
			
	

	}

}
