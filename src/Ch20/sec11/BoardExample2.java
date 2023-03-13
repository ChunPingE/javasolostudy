package Ch20.sec11;

import java.util.Scanner;

public class BoardExample2 {
	// 필드
	private Scanner sc = new Scanner(System.in);

	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("-------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("-------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s \n",
				"1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다.");
		System.out.printf("%-6s%-12s%-16s%-40s \n",
				"2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다.");
		mainMenu();
	}

	public void mainMenu() {
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
		int menuNo = Integer.parseInt(sc.nextLine());
		System.out.println();

		switch (menuNo) {
		case 1:
			create();
			break;
		case 2:
			read();
			break;
		case 3:
			clear();
			break;
		case 4:
			exit();
			break;
		}
	}

	public void create() {
		System.out.println("create메소드 실행");
		list();
	}

	public void read() {
		System.out.println("read메소드 실행");
		list();
	}

	public void clear() {
		System.out.println("clear메소드 실행");
		list();
	}

	public void exit() {
		System.out.println("프로그램 종료");
		System.exit(0);
	}

	public static void main(String[] args) {
		BoardExample2 bd = new BoardExample2();
		bd.list();
	}
}
