<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>
<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>

<script>
	function getfile(filename){
		location.href="<c:url value='download.do' />?filename=" + filename;
	}
</script>

<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>

	<div class="container">
	  <h2>업로드가 완료 되었습니다.</h2>
		  <div class="panel panel-default">
		    <div class="panel-heading">Spring을 이용한 다중 파일 업로드 구현</div>
		    
		    <div class="panel-body">
		    
		    	<table class="table table=bordered table-hover">
		    		<tr>
		    			<td>아이디</td>
		    			<td>${map.id}</td>
		    		</tr>
		    		<tr>
		    			<td>이름</td>
		    			<td>${map.name}</td>
		    		</tr>
		    		<c:forEach var ="fname" items = "${map.fileList }">
		    		<tr>
		    			<td>${fname}</td>
		    			<td>
		    				<a href="javascript:getfile('${fname}')">
		    				<span class="glyphicon glyphicon-file"></span>
		    				</a>
		    			</td>
		    		</tr>
		    		</c:forEach>
		    		<tr>
		    			<td clospan="2" align="center">
		    				<a href="<c:url value='/form.do'/>">다시 업로드</a>
		    			</td>
		    		</tr>
		    	</table>
		    </div>
		    
		    <div class="panel-footer">인프런(화이팅)</div>
		  </div>
	</div>
	
	
</body>
</html>