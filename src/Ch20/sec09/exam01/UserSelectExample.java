package Ch20.sec09.exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSelectExample {
	public static void main(String[] args) {
		Connection conn = null;

		try {
			// JDBC Driver등록
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connection객체 생성
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/thisisjava",
					"chun",
					"1234");
			System.out.println("연결 성공");

			// sql문
			String sql = "SELECT * FROM users WHERE userid=?";

			// prepared
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 값대입
			pstmt.setString(1, "winter");

			// sql문 실행후 resultset
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("userid"));
				user.setUserName(rs.getString("username"));
				user.setUserPassword(rs.getString("userpassword"));
				user.setUserAge(rs.getInt("userage"));
				user.setUserEmail(rs.getString("useremail"));
				System.out.println(user);
			} else {
				System.out.println("사용자아이디가 존재하지 않음");
			}

			rs.close();
			pstmt.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
