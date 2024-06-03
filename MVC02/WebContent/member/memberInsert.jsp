<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<%
	// Pramter 수집(VO)
		request.setCharacterEncoding("UTF-8");
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
	
		if(cnt>0) {
			// 가입성공
			response.sendRedirect("memberList.jsp");
		} else {
			//가입실패 ->예외객체를 만들어서 WAS에게 던지자.
			throw new ServletException("not insert");
		}

%>