<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<%@ page import="java.util.*" %>
<%
ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>

<script>
	function delectFn(num){
		location.href="memberDelete.do?num=" + num;
	}
</script>
</head>
[MVC04 예제 - FrontController+POJO]
<body>
	<table class="table talbe-bordered">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>나이</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>삭제</td>
		</tr>
		<%	for(MemberVO vo : list){ %>
				<tr>
				<td><%=vo.getNum()%></td>
				<td><a href="memberContent.do?num=<%=vo.getNum()%>"><%=vo.getId()%></a></td>
				<td><%=vo.getPass()%></td>
				<td><%=vo.getName()%></td>
				<td><%=vo.getAge()%></td>
				<td><%=vo.getEmail()%></td>
				<td><%=vo.getPhone()%></td>
				<td>
					<input type ="button" value="삭제" class="btn btn-warning" onclick="delectFn(<%=vo.getNum() %>)"> 
				</td>
			</tr>
		<%} %>
			
		<tr>
			<td colspan="8" align="right">
				<input type ="button" value="회원가입" class="btn btn-primary" onclick="location.href='/MVC04/memberRegister.do'">
			</td>
		</tr>
	</table>
	

</body>
</html>