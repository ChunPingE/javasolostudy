package Ch20.sec10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {
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

			// 트랜잭션 시작 ---------------------------------------------------
			// 자동 커미 기능 끄기
			conn.setAutoCommit(false);

			// 출금작업
			String sql1 = "UPDATE accounts SET balance=balance-? WHERE ano= ?";
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, 10000);
			pstmt1.setString(2, "111-111-1111");
			int rows1 = pstmt1.executeUpdate();
			System.out.println(rows1);
			if (rows1 == 0) {
				throw new Exception("출금되지 않았음");
			}
			pstmt1.close();

			// 입금작업
			String sql2 = "UPDATE accounts SET balance=balance+? WHERE ano= ?";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setInt(1, 10000);
			pstmt2.setString(2, "222-222-2222");
			int rows2 = pstmt2.executeUpdate();
			if (rows2 == 0) {
				throw new Exception("입금되지 않았음");
			}
			pstmt2.close();

			//수동 커밋 -> 모두 성공처리
			conn.commit();
			System.out.println("계좌이체성공");
		} catch (Exception e) {
			try {
				conn.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				System.out.println("계좌이체실패");
			}
		} finally {
			try {
				//원래대로 자동 커밋 기능 켜기
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
