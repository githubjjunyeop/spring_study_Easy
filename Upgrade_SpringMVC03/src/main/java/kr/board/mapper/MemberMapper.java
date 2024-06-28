package kr.board.mapper;


import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.Member;


@Mapper // = mybatis API
public interface MemberMapper {
	
	public Member registerCheck(String memID);
	public int register(Member vo); // 회원등록 (성공1, 실패0)
	public Member memLogin(Member mvo); //로그인체크
	public int memUpdate(Member mvo);

}
