package kr.bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

//각각의 POJO가 해야할 일들을 한개의 POJO조 바꿈
public class MemberController   {
	
	// MemberContentController
	@RequestMapping("/memberContent.do")
	public String memberContent(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.MemberContent(num);
		
		request.setAttribute("vo", vo);
		return "memberContent"; // 뷰의 이름만 return 
//		return "/WEB-INF/member/memberContent.jsp";
	}
	
	
	// MemberDeleteController
	@RequestMapping("/memberDelete.do");
	public String memberDelete(HttpServletRequest request, HttpServletResponse reponse)
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
	
	
	//memberInsertController
	@RequestMapping("/memberInsert.do")
	public String memberInsert(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
//		MemberVO vo = new  MemberVO(id, pass, name, age, email, phone);
		MemberVO vo = new  MemberVO();
		
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setAge(age);
		vo.setEmail(email);
		vo.setPhone(phone);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(vo);
//		PrintWriter out =response.getWriter();
		String nextpage = null;
		
		String ctx = request.getContextPath(); // /MVC04
		
		if(cnt>0) {
			nextpage= "redirect:"+ ctx +"/memberList.do";
		} else {
			throw new ServletException("not insert");
		}
		
		return nextpage;
	}
	
	
	//MemberListController
	@RequestMapping("/memberList.do")
	public String memberList(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.memberList();
		
		//2.객체바인딩
		request.setAttribute("list", list);
		
		// 다음페이지는 memberList.jsp 입니다.
		//3.다음페이지 정보(View)
		
		return "memberList";
	}
	
	
	//MemberRegisterController
	@RequestMapping("/memberRegister.do")
	public String memberRegister(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		
		return "memberRegister";
	}
	
	
	//MemberUpdateController
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
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
