package newleccJDBCPrj.ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/dbpractice";
		String sql = "SELECT * FROM NOTICE WHERE HIT >= 10";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "chun", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writerId = rs.getString("WRITER_ID");
			Date regDate = rs.getDate("REGDATE");
			String content = rs.getString("CONTENT");
			int hit = rs.getInt("HIT");
			System.out.printf("id:%d, title:%s, wirterId:%s, regdate:%s, content:%s, hit:%d\n", id, title, writerId,
					regDate, content, hit);
		}

		rs.close();
		st.close();
		con.close();
	}
}
