<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="kr.web.util.*"%>

<%
	Myutil my = new Myutil();  
	int sum =my.hap(); 
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
			<td>1~100까지의 총 합은 </td>
			<td><%= sum %></td>
		</tr>
	</table>
</body>
</html>