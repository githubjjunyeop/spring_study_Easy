package kr.bit.model;
// JDBC ->myBatis, JPA
import java.sql.*;
import java.util.ArrayList;
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
		} finally{
			dbClose();
		}
		
		return cnt;
		
	}
	
	//회원(VO) 전체 리스트 가져오기 (ArrayList) 가져오기
	public ArrayList<MemberVO> memberList( ) {
		
		String SQL = "SELECT * FROM member";
		getConnect();
		
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery(); // rs-> 커서
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
			
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				MemberVO vo = new MemberVO( num, id,  pass,  name,  age,  email,  phone);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
		
	}
	
	public void MemberDelete(String num) {
		
		String SQL = "DELETE FROM member WHERE NUM=?";
		getConnect();
		
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1,num);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	// 데이터베이스 연결 끊기
	
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(rs!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
