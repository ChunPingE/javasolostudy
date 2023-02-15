package ch03객체지향.sec05추상화;

import java.util.Scanner;

public class NewlecExamConsole extends ExamConsole {

	@Override
	protected Exam makeExam() {

		return new NewlecExam();
	}

	@Override
	protected void onInput(Exam exam) {
		NewlecExam newlecExam = (NewlecExam) exam;
		
		Scanner sc = new Scanner(System.in);
		int com;
		do {
			System.out.printf("컴퓨터: ");
			com = sc.nextInt();

			if (com < 0 || 100 < com) {
				System.out.println("컴퓨터성적은 0~100까지의 범위만 입력이 가능합니다.");
			}
		} while (com < 0 || 100 < com);
		
		newlecExam.setCom(com);
		
	}

	@Override
	protected void onPrint(Exam exam) {
		NewlecExam newlecExam = (NewlecExam) exam;
		int com = newlecExam.getCom();
		System.out.printf("컴퓨터: %3d\n", com);

	}

}
