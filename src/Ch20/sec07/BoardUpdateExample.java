package Ch20.sec07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// JDBC Driver등록
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connection객체 생성(연결하기)
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/thisisjava",
					"chun",
					"1234");

			System.out.println("연결 성공");

			// --------------SQL------------
			// 매개변수화된 SQL 문 작성
			String sql = "update boards set " + "btitle = ?, " + "bcontent = ?, " + "bfilename = ?, "
					+ "bfiledata= ? " + "where bno = ? ";
			// PreparedStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 값넣기
			pstmt.setString(1, "눈사람");
			pstmt.setString(2, "눈으로 만든 사람");
			pstmt.setString(3, "업데이트 해보기");
			pstmt.setBlob(4, new FileInputStream("src/ch20/sec07/photo2.png"));
			pstmt.setInt(5, 3);

			// sql문실행
			int rows = pstmt.executeUpdate();
			System.out.println("업데이트된 행수: " + rows);

			// PreparedStatement 닫기
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
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
