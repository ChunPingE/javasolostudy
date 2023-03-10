package Ch20.sec08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDeleteExample {
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

			// SQL문
			String sql = "DELETE FROM boards WHERE bwriter = ?";

			// PreparedSatement객체 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);

			// 값넣기
			pstmt.setString(1, "winter");

			// 실행
			int rows = pstmt.executeUpdate();
			System.out.println("삭제된 행 수: " + rows);

			// 닫기
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					// 연결끊기
					conn.close();
					System.out.println("연결끊기");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
