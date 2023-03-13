package newleccJDBCPrj.com.newlecture.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import newleccJDBCPrj.com.newlecture.app.entity.Notice;
import newleccJDBCPrj.com.newlecture.app.service.NoticeService;

public class NoticeConsole {
	private NoticeService service;
	private int page;
	private String searchField;
	private String searchWord;

	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
		searchField = "TITLE";
		searchWord = "";
	}

	public void printNoticeList() throws ClassNotFoundException, SQLException {
		List<Notice> list = service.getList(page, searchField, searchWord);
		int count = service.getCount();
		int lastPage = count / 5; // 100 -> 20 90 -> 18
		lastPage = count % 5 > 0 ? lastPage + 1 : lastPage;

		System.out.println("---------------------------------------------------------");
		System.out.printf("<공지사항> 총 %d 게시글\n", count);
		System.out.println("---------------------------------------------------------");
		for (Notice n : list) {
			System.out.printf("%d. %s / %s / %s\n", n.getId(), n.getTitle(), n.getWriterId(), n.getRegDate());
		}
		System.out.println("---------------------------------------------------------");
		System.out.printf("           %d/%d pages\n", page, lastPage);
	}

	public int inputNoticeMenu() {
		Scanner sc = new Scanner(System.in);

		System.out.print("1.상세조회/ 2.이전/ 3.다음/ 4.글쓰기/ 5.검색 / 6.종료 >");
		String menu_ = sc.nextLine();
		int menu = Integer.parseInt(menu_);

		return menu;
	}

	public void inputSearchWord() {
		Scanner sc = new Scanner(System.in);
		System.out.println("검색 범주(title/content/writerId) 중에 하나를 입력하세요");
		System.out.print(">");
		searchField = sc.nextLine();

		System.out.print("검색어 >");
		searchWord = sc.nextLine();
	}

	public void movePrevList() {
		if (page == 1) {
			System.out.println("이전 페이지가 없습니다.");
			return;
		}
		this.page--;
	}

	public void moveNextList() throws ClassNotFoundException, SQLException {
		int count = service.getCount();
		int lastPage = count / 5; // 100 -> 20 90 -> 18
		lastPage = count % 5 > 0 ? lastPage + 1 : lastPage;

		if (page == lastPage) {
			System.out.println("다음 페이지가 없습니다.");
			return;
		}
		this.page++;
	}

}
