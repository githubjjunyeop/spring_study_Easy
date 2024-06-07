package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberListController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		
		//2.객체바인딩
		request.setAttribute("list", list);
		
		// 다음페이지는 memberList.jsp 입니다.
		//3.다음페이지 정보(View)
		
		return "memberList";
	}

}
