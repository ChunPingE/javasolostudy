package newleccJDBCPrj.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/dbpractice";

		String title = "TEST3";
		String content = "HAHA";
		String files = "";

		String sql = "UPDATE NOTICE "
				+ "SET "
				+ "TITLE =?, "
				+ "CONTENT =?, "
				+ "FILES=? "
				+ "WHERE ID = ?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "chun", "1234");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, files);
		pstmt.setInt(4, 17);
		int result = pstmt.executeUpdate();
		System.out.println(result);
		pstmt.close();
		con.close();
	}
}
