<%@page import="kr.bit.model.MemberVO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberVO vo = new MemberVO();
	vo.setNum(1);
	vo.setId("bitcocom");
	vo.setName("나길동");
	vo.setEmail("admin@naver.com");
	request.setAttribute("vo", vo);
	
	List<MemberVO> list= new ArrayList<MemberVO>();
	
	list.add(vo);
	list.add(vo);
	list.add(vo);
	list.add(vo);
	
	
	request.setAttribute("list", list);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>			
			<th>이메일</th>			
		</tr>
		<c:forEach var="vo" items="${list}">
		<tr>
			<th>${vo.num}</th>
			<th>${vo.id}</th>
			<th>${vo.name}</th>			
			<th>${vo.email}</th>	

		</tr>
		</c:forEach>			
		
	</table>


</body>
</html>