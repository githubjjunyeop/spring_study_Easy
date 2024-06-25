<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spring MVC01</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 
<div class="container">
  <h2>게시판 수정하기</h2>
  <div class="panel panel-default">
  
    <div class="panel-heading">BOARD</div>
    
    <div class="panel-body">
    	<form action="../boardUpdate.do" method="post">
    	<input type="hidden" name="idx" value="${vo.idx}">
   			<table class="table table-bordered">
	    		<tr>
	    			<th>제목</th>
	    			<td>
	    			<input type="text" name="title" class="form-control" value="${vo.title}" ></td>
	    		</tr>
	    		<tr>
	    			<th>내용</th>
	    			<td>
	    			<textarea rows="7" name="content" class="form-control">${vo.content}</textarea>
	    			</td>
	    		</tr>
	    		<tr>
	    			<th>작성자</th>
	    			<td>
	    				<input type="text"  class="form=control" value="${vo.writer}" readonly>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td colspan="2" align="center">
	    				<button type="submit" class="btn btn-primary btn-sm">수정</button>
	    				<button type="reset" class="btn btn-warning btn-sm">취소</button>
	    				<a href="../boardList.do" class="btn btn-info btn-sm">목록</a>
	    			</td>
	    		</tr>
	    	</table>
    	</form>
    <div class="panel-footer">Spring MVC01 UPGRADE board example</div>
  </div>
</div>

</body>
</html>
