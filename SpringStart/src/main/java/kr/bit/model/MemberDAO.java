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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	private  SqlSessionFactory sqlSessionFactory;
	
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
	
}
