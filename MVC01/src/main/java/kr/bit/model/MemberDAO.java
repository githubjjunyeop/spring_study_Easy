package kr.bit.model;
// JDBC ->myBatis, JPA
import java.sql.*;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//데이터베이스 연결객체
	public void getConnect() {
		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimeZone=UTC";
		String user ="root";
		String ps ="admin12345";
		// MySQL Driver Loading
		
		try {
			//동적로딩(실행지점에서 객체를 생성하는 방법)
			//유지보수가 쉬움
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,ps);
			String sql = "";
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	//회원저장 동작
	
	public int memberInsert(MemberVO vo) {
		String SQL = "INSERT INTO member (id, pass, name, age, email, phone) VALUES(?, ?, ?, ?, ?, ?);";
		getConnect();
		// SQL 문장을 전송하는 객체
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL); // 미리 컴파일을 시킨다.
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			
			// 1 성공 0 실패
			 cnt  =ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
		
	}
	
}
