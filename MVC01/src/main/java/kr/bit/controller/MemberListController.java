package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
														throws ServletException, IOException {
		// 1. 클라이언트의 요청을 받기(memberList.do)
		// 2. 회원 전체 리스트 가져오기(Model 연동)
		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = dao.memberList();
		
		
		// 3. 회원 전체 리스트를 HTML로 만들어서 응답
//		System.out.println(list);
		// 응답되는 데이터안에 한글이 있는 겨우 - 인코딩
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out= response.getWriter();
			out.println("<html>");
			out.println("</body>");
			out.println("<table broder='1'>");
			out.println("<thead>");
		    out.println("<tr>");
		    out.println("<th>번호</th>");
		    out.println("<th>아이디</th>");
		    out.println("<th>비밀번호</th>");
		    out.println("<th>이름</th>");
		    out.println("<th>나이</th>");
		    out.println("<th>이메일</th>");
		    out.println("<th>전화번호</th>");
		    out.println("<th>삭제</th>");
		    
		    out.println("</tr>");
		    out.println("</thead>");
		    out.println("<tbody>");
		    out.println("<tr>");
		    for(MemberVO vo : list) {
			    out.println("<td>"+vo.getNum() +"</td>");
			    out.println("<td>"+vo.getId() +"</td>");
			    out.println("<td>"+vo.getPass() +"</td>");
			    out.println("<td>"+vo.getName() +"</td>");
			    out.println("<td>"+vo.getAge() +"</td>");
			    out.println("<td>"+vo.getEmail() +"</td>");
			    out.println("<td>"+vo.getPhone() +"</td>");
			    out.println("<th><a href='/MVC01/memberDelete.do?num="+vo.getNum()+"'>삭제</a></th>");
			    out.println(" </tr>");
			}
		    out.println("<tr>");
		    out.println("<td colspan='8' align='center'>");
		    out.println("<a href='/MVC01/member/memberRegister.html'>회원가입</a>");
		    out.println("</td>");
		    
		    out.println("</tr>");
		    
		    out.println("</tbody>");
		    out.println("</table>");
		    out.println("<html>");
		    out.println("</body>");
	}

}
