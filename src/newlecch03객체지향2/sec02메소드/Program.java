package newlecch03객체지향2.sec02메소드;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		ExamList list = new ExamList();

		list.init();

		int menu;
		boolean keepLoop = true;

		while (keepLoop) {

			menu = inputMenu();

			switch (menu) {
			case 1:
				list.inputList();
				break;
			case 2:
				list.printList();
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

	static int inputMenu() {
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
