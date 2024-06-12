package kr.bit.model;
// JDBC ->myBatis
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class MemberDAO {
	private static SqlSessionFactory sqlSessionFactory;
	
	
	static {
		try {
			String resource = "kr/bit/mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//회원 전체 리스트 보기
	public List<MemberVO> memberList() {
		// connection+Statement => SqlSession 
		SqlSession session = sqlSessionFactory.openSession();
		List<MemberVO> list = session.selectList("memberList");
		session.close(); //반납
		return list;
	}
	
	//회원가입
	public int memberInsert(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		
		int cnt = session.insert("memberInsert", vo);
		session.commit(); //반납
		session.close(); //반납
		return cnt;
	}
	
	//삭제
	public int memberDelete(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		
		int cnt = session.delete("memberDelete", num);
		session.commit(); //반납
		session.close(); //반납
		return cnt;
	}
	
	//상세보기
	public MemberVO memberContent(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		
		MemberVO vo = session.selectOne("memberContent", num);
		session.commit(); //반납
		session.close(); //반납
		return vo;
	}
	
	public int memberUpdate(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt =  session.update("memberUpdate", vo);
		
		session.commit(); //반납
		session.close(); //반납
		return cnt;
	}
	
	public String memberLogin(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		String user_name =  session.selectOne("memberLogin", vo);
		
		
		session.close(); //반납
		return user_name;
	}
	//중복확인
	
	public String memberDbcheck(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		String dbid = session.selectOne("memberDbcheck", id);
		String idDouble = "NO";
		
		if(dbid !=null) {
			idDouble = "YES";
		}
		return idDouble; // YES(중복), NO(중복아님);
	}
	
}
