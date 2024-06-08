<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*"%>
    
<%

	
	//MemberVO vo = (MemberVO)request.getAttribute("vo"); 
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
	

</head>
<body>
	<h1>${vo.name} 회원 상세보기</h1>
	<form name="formDate" action="${ctx}/memberUpdate.do" method="post" return="false">
	<table class="table talbe-bordered">
	<input type="hidden" name="num" value=${vo.num}>
	<c:if test="${vo!=null}">
		<tr>
			<td>번호</td>
			<td>${vo.num}</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>${vo.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${vo.pass}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${vo.name}</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>
				<input type="text" value=${vo.age} name="age">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" value=${vo.email} name="email">
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<input type="text" value=${vo.phone} name="phone">
			</td>
		</tr>
		</c:if>
		<c:if test="${vo==null }">
		<tr>
			<td>일치하는 회원이 없습니다.</td>
		</tr>
		</c:if>
		<tr>
			<td colspan="2" align ="center">
				<button onclick="updateFn()" class="btn btn-warning">수정하기</button>
				<button onclick="reset" class="btn btn-primary">취소</button>
				<button onclick="location.href='${ctx}/memberList.do'" class="btn btn-success" >List돌아가기</button>
			</td>
		</tr>
		
		
	
	</table>
	</form>
	
	

</body>
</html>