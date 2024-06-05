package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class MemberDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		
		String ctx = request.getContextPath(); // /MVC04
				
		String num = request.getParameter("num"); 
		int cnt = dao.MemberDelete(num);
		String nextpage = "";
		if(cnt > 0) {
			nextpage = "redirect:"+ctx+"/memberList.do";			
		} else {
			throw new ServletException("not delete");
		}
		
		return nextpage;
	}

}
