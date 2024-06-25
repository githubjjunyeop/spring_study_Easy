<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("newLineChar", "\n"); %>
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
  <h2>게시판 상세보기</h2>
  <div class="panel panel-default">
  
    <div class="panel-heading">BOARD</div>
    
    <div class="panel-body">
    	
   			<table class="table">
	    		<tr>
	    			<th>제목</th>
	    			<td>
	    				${vo.title}
	    			</td>
	    		</tr>
	    		<tr>
	    			<th>내용</th>
	    			<td>
	    				${fn:replace(vo.content, newLineChar,"<br/>")}
	    			</td>
	    		</tr>
	    		<tr>
	    			<th>작성자</th>
	    			<td>
	    				${vo.writer}
	    			</td>
	    		</tr>
	    		<tr>
	    			<th>작성일</th>
	    			<td>
	    				${fn:split(vo.indate," ")[0]}
	    			</td>
	    		</tr>
	    		<tr>
	    			<td colspan="2" align="center" alugn="center">
	    				<a href="boardUpdateForm.do/${vo.idx}" class="btn btn-primary btn-sm">수정화면</a>
	    				<a href="boardDelete.do/${vo.idx}" class="btn btn-warning btn-sm">삭제</a>
	    				<a href="boardList.do" class="btn btn-info btn-sm">목록</a>
	    			</td>
	    		</tr>
	    	</table>
    
    <div class="panel-footer">Spring MVC01 UPGRADE board example</div>
  </div>
</div>

</body>
</html>
