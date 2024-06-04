package kr.bit.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
														throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 클라이언트가 어떤 요청을 했는지 파악하기
		String url= request.getRequestURI();
		System.out.println(url);
		
		String ctx = request.getContextPath();
		System.out.println(ctx);
		
		//실제로 요청한 명령이 무엇인지
		String command = url.substring(ctx.length());
		System.out.println(command);
		
		//요청에 따른 분기작업
		
		if(command.equals("/memberList.do")) {
			MemberDAO dao = new MemberDAO();
			List<MemberVO> list = dao.memberList();
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
			rd.forward(request, response);
			
		} else if(command.equals("/memberInsert.do")) {
			
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
//			MemberVO vo = new  MemberVO(id, pass, name, age, email, phone);
			MemberVO vo = new  MemberVO();
			
			vo.setId(id);
			vo.setPass(pass);
			vo.setName(name);
			vo.setAge(age);
			vo.setEmail(email);
			vo.setPhone(phone);
			
			MemberDAO dao = new MemberDAO();
			int cnt = dao.memberInsert(vo);
			PrintWriter out =response.getWriter();
			if(cnt>0) {
				response.sendRedirect("/MVC04//memberList.do");
			} else {
				throw new ServletException("not insert");
			}
			
		} else if(command.equals("/memberRegister.do")) { 
			RequestDispatcher rd = request.getRequestDispatcher("member/memberRegister.html");
			rd.forward(request, response);
			
		} else if(command.equals("/memberContent.do")) { 
			int num = Integer.parseInt(request.getParameter("num"));
			MemberDAO dao = new MemberDAO();
			MemberVO vo = dao.MemberContent(num);
			
			request.setAttribute("vo", vo);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberContent.jsp");
			rd.forward(request, response);
			
		} else if(command.equals("/memberUpdate.do")) { 
			request.setCharacterEncoding("UTF-8");
			int num = Integer.parseInt(request.getParameter("num"));
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			MemberVO vo = new MemberVO();
			vo.setNum(num);
			vo.setAge(age);
			vo.setEmail(email);
			vo.setPhone(phone);
			
			MemberDAO dao = new MemberDAO();
			int cnt = dao.MemberUpdate(vo);
			
			if(cnt>0) {
				// 가입성공
				response.sendRedirect("/MVC04/memberList.do");
			} else {
				//가입실패 ->예외객체를 만들어서 WAS에게 던지자.
				throw new ServletException("not Update");
			}
		} else if(command.equals("/memberDelete.do")) { 
			
			MemberDAO dao = new MemberDAO();

			String num = request.getParameter("num"); 
			int cnt = dao.MemberDelete(num);
			if(cnt > 0) {
				response.sendRedirect("/MVC04/memberList.do");			
			} else {
				throw new ServletException("not delete");
			}
		}
		
	}

}
