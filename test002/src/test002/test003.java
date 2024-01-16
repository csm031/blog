package test002; // 패키지 선언. 이 코드가 속한 패키지의 이름은 'test002'입니다.

import java.sql.Connection; // JDBC를 사용하여 데이터베이스와 연결을 생성하는 데 필요한 클래스를 임포트합니다.
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test003 { // 'test003'이라는 이름의 public 클래스를 선언합니다.

	public static void main(String[] args) { // 메인 메소드를 선언합니다. 자바 애플리케이션의 진입점입니다.

		String driver = "oracle.jdbc.driver.OracleDriver"; // 사용할 JDBC 드라이버의 이름을 문자열로 저장합니다.
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스에 연결하기 위한 URL을 저장합니다.
		String user = "c##csm"; // 데이터베이스 사용자 이름을 저장합니다.
		String password = "csm"; // 데이터베이스 비밀번호를 저장합니다.
		Connection conn = null; // Connection 객체를 null로 초기화합니다.

		try {
			// driver 로딩
			Class.forName(driver); // JDBC 드라이버를 로드합니다.
			System.out.println("jdbc driver 로딩 성공");

			// DB와 연결
			conn = DriverManager.getConnection(url, user, password); // DriverManager를 사용하여 데이터베이스에 연결합니다.
			System.out.println("오라클 연결 성공");

			// SQL 쿼리 실행
			String sql = "SELECT * FROM USER_INFORMATION"; // 실행할 SQL 쿼리를 문자열로 저장합니다.
			Statement stmt = conn.createStatement(); // Statement 객체를 생성합니다.
			ResultSet rs = stmt.executeQuery(sql); // SQL 쿼리를 실행하고 그 결과를 ResultSet 객체에 저장합니다.

			// 결과 출력
			while (rs.next()) { // ResultSet에 다음 행이 있으면 true를 반환하고, 그 행을 가져옵니다.
				System.out.println(rs.getString("USER_ID")); // "USER_ID" 컬럼의 값을 가져와 출력합니다.
				System.out.println(rs.getString("USER_name")); // "USER_name" 컬럼의 값을 가져와 출력합니다.
				System.out.println(rs.getString("USER_password")); // "USER_password" 컬럼의 값을 가져와 출력합니다.
				System.out.println(rs.getString("USER_email")); // "USER_email" 컬럼의 값을 가져와 출력합니다.
				System.out.println(rs.getString("CREATED_DATE")); // "CREATED_DATE" 컬럼의 값을 가져와 출력합니다.
				System.out.println(rs.getString("login_ID")); // "login_ID" 컬럼의 값을 가져와 출력합니다.
			}

			// 자원 해제
			rs.close(); // ResultSet 객체를 닫습니다.
			stmt.close(); // Statement 객체를 닫습니다.
			conn.close(); // Connection 객체를 닫습니다.
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패"); // JDBC 드라이버 로딩에 실패하면 이 메시지를 출력합니다.
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패"); // 데이터베이스 연결에 실패하면 이 메시지를 출력합니다.
		}
	}
}
