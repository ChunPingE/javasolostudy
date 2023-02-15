package Ch05.sec11test;

import java.util.Scanner;

public class No9 {

	public static void main(String[] args) {
		int stnum = 0;
		int[] arr = null;
		
		boolean bo = true;
		while(bo) {
			
			int menu = mainmenu();
			
			switch (menu) {
			
			case 1:
				stnum = stnum();
				arr = new int[stnum];
				break;
			case 2:
				input(arr);
				break;
			case 3:
				list(arr);
				break;
			case 4: 
				analyze(arr);
				break;
			case 5:
				System.out.println("프로그램 종료");
				bo = false;
				break;
			}
		}

	}

	public static void analyze(int[] arr) {
		int max = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(arr[i]> max) {
				max = arr[i];
			}
		}
		System.out.println("최고 점수: " + max);
		System.out.println("평균 점수: " + (double)sum / arr.length);
	}


	public static void list(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr["+ i + "]: " + arr[i]);
		}
	}


	public static int mainmenu() {
		System.out.println("---------------------------------------------------");
		System.out.println("1.학생수 |2.점수입력 |3.점수리스트 |4.분석 | 5.종료");
		System.out.println("---------------------------------------------------");
		Scanner sc = new Scanner(System.in);
		System.out.print("선택> ");
		int menu = Integer.parseInt(sc.nextLine());
		return menu;
	}


	public static void input(int[] arr) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.print("arr[" +  i +"]" + "> ");
			arr[i]= Integer.parseInt(sc.nextLine());
		}
	}


	public static int stnum() {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생수> ");
		int num = Integer.parseInt(sc.nextLine());

		return num;

	}

}
