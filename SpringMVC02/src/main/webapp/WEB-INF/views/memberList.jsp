<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<%@ page import="java.util.*" %>
<%
ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
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
		location.href="${ctx}/memberDelete.do?num=" + num;
	}
	
	function btnClick(){
		$.ajax({
			url : "<c:url value='/memberAjaxList.do'/>",
			type : "get",
			dataType : "json",
			success : resultHtml,
			error : function(){ alert("error"); }
		});
	}
	
	function resultHtml(data){
		console.log(data);
		var html ="<table class='table table-bordered'>";
		html +="<tr>";
		html +="<td>번호</td>";
		html +="<td>아이디</td>";
		html +="<td>비밀번호</td>";
		html +="<td>이름</td>";
		html +="<td>나이</td>";
		html +="<td>이메일</td>";
		html +="<td>전화번호</td>";
		html +="</tr>";
		
		$.each(data,function(index, obj){
			html +="<tr>";
			html +="<td>"+obj.num+"</td>";
			html +="<td>"+obj.id+"</td>";
			html +="<td>"+obj.pass+"</td>";
			html +="<td>"+obj.name+"</td>";
			html +="<td>"+obj.age+"</td>";
			html +="<td>"+obj.email+"</td>";
			html +="<td>"+obj.phone+"</td>";
			html +="</tr>";
			
		});
		
		
		html +="</table>";
		$("#list").html(html);
	}
	
</script>
</head>
<body>
[Spring WEB MVC 02버전]
	<table class="table table-bordered">
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
				<td><a href="${ctx}/memberContent.do?num=<%=vo.getNum()%>"><%=vo.getId()%></a></td>
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
				<input type ="button" value="회원가입" class="btn btn-primary" onclick="location.href='${ctx}/memberRegister.do'">
			</td>
		</tr>
		
		<tr>
			<td colspan="8">
				<input type="button" value="Ajax로 회원리스트보기" onclick="btnClick()">
			</td>
		</tr>
		
	</table>
	
	<div id="list">회원리스트 출력</div>

</body>
</html>