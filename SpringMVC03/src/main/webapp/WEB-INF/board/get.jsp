<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <script>
  	$(document).ready(()=>{
  		$("#list").click(()=>{
  			location.href="<c:url value='/list.do' />";
  		});
  		
  		$("#modify").click(()=>{
  			//var idx = $("#idx").val();
  			//alert('${board.idx}');
  			//location.href="<c:url value='/modify.do'/>?bno="+idx;
  			location.href="<c:url value='/modify.do'/>?bno="+${board.idx}; //get 
  		});
  		
  	});
  
  </script>
</head>
<body>

	<div class="container">
	  <h2>Board Read</h2>
	  <div class="panel panel-default">
	  
	    <div class="panel-heading"> Board read page </div>
	    
	    <div class="panel-body">
	    
	    	<div class="form-group">
			    <label>Bno</label>
			    <input type="text" class="form-control" id="idx" name="idx" value="${board.idx}" readonly>
			  </div>
	    
	    	<div class="form-group">
			    <label>Title</label>
			    <input type="text" class="form-control" name="title" value="${board.title}" readonly>
			  </div>
			  
			  <div class="form-group">
			    <label>Text area</label>
			    <textarea class="form-control" rows="7" name="contents"  readonly> ${board.contents} </textarea>
			  </div>
			  
			  <div class="form-group">
			    <label>Writer</label>
			    <input type="text" class="form-control" name="writer" value="${board.writer}" readonly >
			  </div>
	    		<button id="modify" class="btn btn-default">modify</button>
	    		<button id="list" class="btn btn-info">List</button>
	    </div>
	    
	    <div class="panel-footer">발바닥</div>
	  </div>
	</div>
 


</body>
</html>
