package kr.board.mapper;


import org.apache.ibatis.annotations.Mapper;

import kr.board.entity.AuthVO;
import kr.board.entity.Member;


@Mapper // = mybatis API
public interface MemberMapper {
	
	public Member registerCheck(String memID);
	public int register(Member vo); // 회원등록 (성공1, 실패0)
	public Member memLogin(String username); //로그인체크
	public int memUpdate(Member mvo);
	public Member getMember(String memID);
	public void memProfileUpdate(Member mvo);
	public void authInsert(AuthVO saveVO);
	public void authDelete(String memID);
}
