package newleccJDBCPrj.ex1;

import java.sql.SQLException;

import newleccJDBCPrj.com.newlecture.app.console.NoticeConsole;

public class Program5 {
	public static void main(String[] args) {
		NoticeConsole console = new NoticeConsole();
		// int page = 1;
		try {
			Exit: while (true) {
				console.printNoticeList();
				int menu = console.inputNoticeMenu();

				switch (menu) {
				case 1: // 상세조회
					break;
				case 2: // 이전
					console.movePrevList();
					// page--;
					break;
				case 3: // 다음
					console.moveNextList();
					// page++;
					break;
				case 4: // 글쓰기
					break;
				case 5: // 검색
					console.inputSearchWord();
					break;
				case 6: // 종료
					System.out.println("BYE~ ");
					break Exit;
				default:
					System.out.println("<사용방법> 메뉴는 1~4까지만 입력 가능");
					break;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
