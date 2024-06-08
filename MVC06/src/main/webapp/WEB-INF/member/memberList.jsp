<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*" %>
<%@ page import="java.util.*" %>
<%
 //ArrayList<MemberVO> list = (ArrayList<MemberVO>)request.getAttribute("list");
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
</script>
</head>

<body>

<div class="container">
	<h2>회원관리 시스템</h2>
	<div class="panel panel-default">
  		<div class="panel-heading">
  
			<form class="form-inline" action="" method="post">
	  			<div class="form-group">
	    			<label for="user_id">ID:</label>
	    			<input type="text" class="form-control" id=uese_id" name="uese_id">
	  			</div>
			  	<div class="form-group">
			    	<label for="pwd">Password:</label>
			    	<input type="password" class="form-control" id="password" name="password">
			  	</div>
			  		<button type="submit" class="btn btn-default">Submit</button>
			</form>
	
  		</div>
  <div class="panel-body">
   <div class="table-responsive">          
	  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>삭제</th>
	      </tr>
	    </thead>
	    <tbody>
	    <c:forEach var="vo" items="${list}">
				<tr>
				<td>${vo.num}</td>
				<td><a href="${ctx}/memberContent.do?num=${vo.num}">${vo.id}</a></td>
				<td>${vo.pass}</td>
				<td>${vo.name}</td>
				<td>${vo.age}</td>
				<td>${vo.email}%></td>
				<td>${vo.phone}</td>
				<td>
					<input type ="button" value="삭제" class="btn btn-warning" onclick="delectFn(${vo.num})"> 
				</td>
			</tr>
		</c:forEach>
	    </tbody>
	  </table>
 	 </div>
  </div>
 </div>
</div>





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
		<c:forEach var="vo" items="${list}">
				<tr>
				<td>${vo.num}</td>
				<td><a href="${ctx}/memberContent.do?num=${vo.num}">${vo.id}</a></td>
				<td>${vo.pass}</td>
				<td>${vo.name}</td>
				<td>${vo.age}</td>
				<td>${vo.email}%></td>
				<td>${vo.phone}</td>
				<td>
					<input type ="button" value="삭제" class="btn btn-warning" onclick="delectFn(${vo.num})"> 
				</td>
			</tr>
		</c:forEach>
			
		<tr>
			<td colspan="8" align="right">
				<input type ="button" value="회원가입" class="btn btn-primary" onclick="location.href='${ctx}/memberRegister.do'">
			</td>
		</tr>
	</table>
	

</body>
</html>