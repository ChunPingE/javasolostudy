package newleccJDBCPrj.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/dbpractice";

		int id = 17;

		String sql = "DELETE FROM NOTICE WHERE ID=?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "chun", "1234");
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		int result = pstmt.executeUpdate();
		System.out.println(result);
		pstmt.close();
		con.close();
	}
}
