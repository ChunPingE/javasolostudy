package newleccJDBCPrj.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/dbpractice";

		String title = "test2";
		String writerId = "newlec";
		String content = "hahaha";
		String files = "";

		String sql = "INSERT INTO notice(TITLE, WRITER_ID, CONTENT, FILES) "
				+ "VALUES(?, ?, ?, ?)";

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, "chun", "1234");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, writerId);
		pstmt.setString(3, content);
		pstmt.setString(4, files);
		int result = pstmt.executeUpdate();
		System.out.println(result);
		pstmt.close();
		con.close();
	}
}
