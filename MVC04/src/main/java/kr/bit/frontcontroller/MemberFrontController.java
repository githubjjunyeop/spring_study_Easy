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

import kr.bit.controller.Controller;
import kr.bit.controller.MemberContentController;
import kr.bit.controller.MemberDeleteController;
import kr.bit.controller.MemberInsertController;
import kr.bit.controller.MemberListController;
import kr.bit.controller.MemberRegisterController;
import kr.bit.controller.MemberUpdateController;
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
		Controller controller = null;
		String nextpage = null;
		if(command.equals("/memberList.do")) {
			controller = new MemberListController();
			nextpage = controller.requestHandler(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(nextpage);
			rd.forward(request, response);
			
		} else if(command.equals("/memberInsert.do")) {
			controller = new MemberInsertController();
			nextpage = controller.requestHandler(request,response);
			response.sendRedirect(nextpage);
		} else if(command.equals("/memberRegister.do")) { 
			controller = new MemberRegisterController();
			nextpage = controller.requestHandler(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(nextpage);
			rd.forward(request, response);
		} else if(command.equals("/memberContent.do")) { 
			controller = new MemberContentController();
			nextpage = controller.requestHandler(request,response);
			RequestDispatcher rd = request.getRequestDispatcher(nextpage);
			rd.forward(request, response);
		} else if(command.equals("/memberUpdate.do")) { 
			controller = new MemberUpdateController();
			nextpage = controller.requestHandler(request,response);
			response.sendRedirect(nextpage);
		} else if(command.equals("/memberDelete.do")) { 
			controller = new MemberDeleteController();
			nextpage = controller.requestHandler(request,response);
			response.sendRedirect(nextpage);
		}
		
	}

}
