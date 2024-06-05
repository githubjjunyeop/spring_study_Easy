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

import kr.bit.controller.*;

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
		
		
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextpage =  controller.requestHandler(request,response);
		
		if(nextpage != null) {
			if(nextpage.indexOf("redirect:")!=-1) {
				// "redirect:/MVC04/memberList.do";
				response.sendRedirect(nextpage.split(":")[1]);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeView(nextpage)); // forward
				rd.forward(request, response);
			}
			
		}
		
	}

}
