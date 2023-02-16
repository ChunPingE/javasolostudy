package newlecch01java.ex02.sec07.control;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		int kor1, kor2, kor3;
		int total;
		float avg;

		Scanner sc = new Scanner(System.in);

		kor1 = 50;
		kor2 = 60;
		kor3 = 80;

		while (true) {

			// -------성적입력부분------------------------------
			System.out.println("┌──────────────────────────┐");
			System.out.println("│          성적입력        │");
			System.out.println("└──────────────────────────┘");
			
			System.out.print("국어1:");
			kor1 = sc.nextInt();

		
		

			System.out.print("국어2:");
			kor2 = sc.nextInt();
			System.out.print("국어3:");
			kor3 = sc.nextInt();

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
		}
	}

}
