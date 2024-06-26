<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.bit.model.*"%>
    
<%

	
	MemberVO vo = (MemberVO)request.getAttribute("vo"); 
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
	function updateFn(){
		let formData = document.formDate;
		formData.submit();
	}
</script>
</head>
<body>
	<h1><%=vo.getName() %> 회원 상세보기</h1>
	<form name="formDate" action="memberUpdate.do" method="post" return="false">
	<table class="table talbe-bordered">
	<input type="hidden" name="num" value=<%=vo.getNum() %>>
		<tr>
			<td>번호</td>
			<td><%=vo.getNum()%></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=vo.getId()%></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=vo.getPass()%></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=vo.getName()%></td>
		</tr>
		<tr>
			<td>나이</td>
			<td>
				<input type="text" value=<%=vo.getAge() %> name="age">
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<input type="text" value=<%=vo.getEmail() %> name="email">
			</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>
				<input type="text" value=<%=vo.getPhone() %> name="phone">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align ="center">
				<button onclick="updateFn()" class="btn btn-warning">수정하기</button>
				<button onclick="reset" class="btn btn-primary">취소</button>
				<button location.href="MVC03/memberList.do" class="btn">List돌아가기</button>
			</td>
		</tr>
		
		
	
	</table>
	</form>
	
	

</body>
</html>