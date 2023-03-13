package newleccJDBCPrj.com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import newleccJDBCPrj.com.newlecture.app.entity.Notice;

public class NoticeService {
	private String url = "jdbc:mysql://localhost:3306/dbpractice";
	private String uid = "chun";
	private String pwd = "1234";
	private String driver = "com.mysql.cj.jdbc.Driver";

	public int getCount() throws SQLException, ClassNotFoundException {
		int count = 0;
		String sql = "SELECT COUNT(ID) COUNT from notice";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			count = rs.getInt("COUNT");
		}

		rs.close();
		pstmt.close();
		con.close();

		return count;
	}

	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		String sql = "select * from notice_view WHERE " + field + " LIKE ? LIMIT ?, ?";

		int start = 0 + (page - 1) * 5; // 1 , 11, 21 ,31
		int end = 5; // 10 20 30 40

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + query + "%");
		pstmt.setInt(2, start);
		pstmt.setInt(3, end);
		ResultSet rs = pstmt.executeQuery();

		List<Notice> list = new ArrayList<>();

		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");

			Notice notice = new Notice(
					id,
					title,
					writerId,
					regDate,
					content,
					hit,
					files);
			list.add(notice);
		}

		rs.close();
		pstmt.close();
		con.close();

		return list;
	}

	public int insert(Notice notice) throws ClassNotFoundException, SQLException {

		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();

		String sql = "INSERT INTO notice(TITLE, WRITER_ID, CONTENT, FILES) "
				+ "VALUES(?, ?, ?, ?)";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, writerId);
		pstmt.setString(3, content);
		pstmt.setString(4, files);
		int result = pstmt.executeUpdate();
		System.out.println(result);
		pstmt.close();
		con.close();
		return result;
	}

	public int update(Notice notice) throws ClassNotFoundException, SQLException {

		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();

		String sql = "UPDATE NOTICE "
				+ "SET "
				+ "TITLE =?, "
				+ "CONTENT =?, "
				+ "FILES=? "
				+ "WHERE ID = ?";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, files);
		pstmt.setInt(4, id);
		int result = pstmt.executeUpdate();
		System.out.println(result);
		pstmt.close();
		con.close();
		return result;
	}

	public int delete(int id) throws ClassNotFoundException, SQLException {
		String sql = "DELETE FROM NOTICE WHERE ID=?";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, uid, pwd);
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		int result = pstmt.executeUpdate();
		System.out.println(result);
		pstmt.close();
		con.close();
		return result;
	}

}
