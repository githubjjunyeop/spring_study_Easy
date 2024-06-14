package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberUpdateController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int num = Integer.parseInt(request.getParameter("num"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		MemberVO vo = new MemberVO();
		if(request.getParameter("mode").equals("fupdate")) {
			String filename = request.getParameter("filename");
			vo.setFilename(filename);
		}
		
		vo.setNum(num);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		MemberDAO dao = new MemberDAO();
		int cnt = -1;
		if(request.getParameter("mode").equals("fupdate")) {
			cnt = dao.memberUpdateFile(vo);
		} else {
			cnt = dao.memberUpdate(vo);
		}
		
		
		String nextpage = null;
		String ctx = request.getContextPath(); // /MVC04
		
		if(cnt>0) {
			// 수정성공
			nextpage = "redirect:"+ctx+"/memberList.do";
		} else {
			//가입실패 ->예외객체를 만들어서 WAS에게 던지자.
			throw new ServletException("not Update");
		}
		
		return nextpage;
	}

}
