package kr.bit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet {
		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();

		String num = request.getParameter("num"); 
		int cnt = dao.MemberDelete(num);
		if(cnt > 0) {
			response.sendRedirect("/MVC03/memberList.do");			
		} else {
			throw new ServletException("not delete");
		}
	}

}
