package Ch20.sec06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardInsertExample {
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
			String sql = 
					 "INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " +
					 "VALUES (?, ?, ?, now(), ?, ?)";

			// PreparedStatement 얻기
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// 값넣기
			pstmt.setString(1, "눈오는날4");
			pstmt.setString(2, "함박눈이 내려요4");
			pstmt.setString(3, "winter");
			pstmt.setString(4, "4번");
			pstmt.setBlob(5, new FileInputStream("src/ch20/sec06/photo1.png"));

			// sql문실행
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행수: " + rows);
			
			//bno값 얻기
			if (rows ==1 ) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) { //가져온 값이 있다면 실행
					int bno = rs.getInt(1); //가져온 값중 1번
					System.out.println("저장된 bno: " + bno);
				}
				rs.close();
			}

			// PreparedStatement 닫기
			pstmt.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일이 없습니다.");
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
