<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String data = (String)request.getAttribute("data");

	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	Controller에서 받은 값을 출력 : ?
								<%=name %>
								<%=age %>
								<%=email %>

</body>
</html>