package Ch20.sec09.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelectExample {
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
			String sql = "SELECT * FROM boards WHERE bwriter=?";

			// prepared
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 값대입
			pstmt.setString(1, "winter");

			// sql문 실행후 resultset
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));
				System.out.println(board);
				// 파일로저장
				Blob blob = board.getBfiledata();
				if (blob != null) {
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream("C:/Temp/" +
							board.getBfilename());
					is.transferTo(os);
					os.flush();
					os.close();
					is.close();
				}
			}
			rs.close();

			// PreparedStatement 닫기
			pstmt.close();
		} catch (

		ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
