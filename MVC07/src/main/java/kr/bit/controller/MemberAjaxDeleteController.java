package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class MemberAjaxDeleteController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		MemberDAO dao = new MemberDAO();
		
		int num = Integer.parseInt(request.getParameter("num"));  
		int cnt = dao.memberDelete(num);
		response.getWriter().print(cnt);
		
		return null;
	}

}
