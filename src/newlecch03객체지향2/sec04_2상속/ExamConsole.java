package newlecch03객체지향2.sec04_2상속;

import java.util.Scanner;

public class ExamConsole {

	private ExamList list;

	public ExamConsole() {
		list = new ExamList();
	}

	// 기본값 = 리스트의 개수
	public void printList() {
		printList(list.size());
	}

	public void printList(int size) {
		System.out.println("┌──────────────────────────┐");
		System.out.println("│          성적출력        │");
		System.out.println("└──────────────────────────┘");
		System.out.println();

		for (int i = 0; i < size; i++) {
			Exam exam = list.get(i); // ;

			int kor = exam.getKor(); // exam.kor;
			int eng = exam.getEng();
			int math = exam.getMath();

			int total = exam.total(); // kor + eng + math;
			float avg = exam.avg(); // total / 3.0f;

			System.out.printf("국어: %3d\n", kor);
			System.out.printf("영어: %3d\n", eng);
			System.out.printf("수학: %3d\n", math);

			System.out.printf("총점 : %3d\n", total);
			System.out.printf("평균 : %6.2f\n", avg);
			System.out.println("────────────────────────");
		}
	}

	public void inputList() {
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

		Exam exam = new Exam(kor, eng, math);

		// --------add ----------
		list.add(exam);
		System.out.println("────────────────────────");
	}
}
