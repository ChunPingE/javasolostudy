package newlecch02Structedjava.sec03데이터구조화;

import java.util.Scanner;

public class ListProgram2 {

	public static void main(String[] args) {
		ExamList list = new ExamList();
		list.exams = new Exam[3];
		list.current = 0;

		int menu;
		boolean keepLoop = true;

		while (keepLoop) {

			menu = inputMenu();

			switch (menu) {
			case 1:
				inputList(list);
				break;
			case 2:
				printList(list);
				break;
			case 3:
				System.out.println("Bye~~");
				keepLoop = false;
				break;

			default:
				System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
			}

		}
	}
	

	private static void printList(ExamList list) {
		System.out.println("┌──────────────────────────┐");
		System.out.println("│          성적출력        │");
		System.out.println("└──────────────────────────┘");
		System.out.println();
		
		int size = list.current;
		Exam[] exams = list.exams;
		
		for (int i = 0; i < size; i++) {
			Exam exam = exams[i];

			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;

			int total = kor + eng + math;
			float avg = total / 3.0f;

			System.out.printf("국어: %3d\n", kor);
			System.out.printf("영어: %3d\n", eng);
			System.out.printf("수학: %3d\n", math);

			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");
		}
	}

	private static void inputList(ExamList list) {
		Scanner sc = new Scanner(System.in);

		System.out.println("┌──────────────────────────┐");
		System.out.println("│          성적입력        │");
		System.out.println("└──────────────────────────┘");
		System.out.println();

		int kor, eng, math;

		do {
			System.out.printf("국어: ");
			kor = sc.nextInt();

			if (kor < 0 || 100 < kor) {
				System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
			}
		} while (kor < 0 || 100 < kor);

		do {
			System.out.printf("영어: ");
			eng = sc.nextInt();

			if (eng < 0 || 100 < eng) {
				System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");
			}
		} while (eng < 0 || 100 < eng);

		do {
			System.out.printf("수학: ");
			math = sc.nextInt();

			if (math < 0 || 100 < math) {
				System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");
			}
		} while (math < 0 || 100 < math);

		Exam exam = new Exam();
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;
		
		/*
		if(!exams의 공간이 있는지){
		공간늘려주기
		*/
		
		
		Exam[] exams = list.exams;
		int size = list.current;
		
		if (exams.length == size) {
			//1.크기가 5개정도 더 큰 새로운 배열생성
			Exam[] temp = new Exam[size + 5];
			//2.값이주
			for (int i = 0; i < size; i++) {
				temp[i] = exams[i];
			}
			//3.list.exams가 새로만든 temp 배열참조 
			list.exams = temp;
			
		}
		
		list.exams[list.current] = exam;
		list.current++;
		

		System.out.println("────────────────────────");
	}

	private static int inputMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("┌──────────────────────────┐");
		System.out.println("│          메인메뉴        │");
		System.out.println("└──────────────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
		int menu = sc.nextInt();
		return menu;
	}

}
