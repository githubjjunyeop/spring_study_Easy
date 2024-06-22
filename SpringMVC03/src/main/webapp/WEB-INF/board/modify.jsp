<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  				location.href="<c:url value='/list.do'/>";
  			});
  			
  			$("#remove").click(()=>{
  				location.href="<c:url value='/remove.do'/>?bno="+${board.idx};
  			});
  			
  		});
  </script>
</head>
<body>
 <br>
	<div class="container">
	
	  
	  <h2>Board Modify Page</h2>
	  <div class="panel panel-default">
	  
	    <div class="panel-heading">Board Modify</div>
	    
	    <div class="panel-body">
	    
	    	<form action="<c:url value='/modify.do' />" method="post">
	    	
	    	  <div class="form-group">
			    <label>Bno</label>
			    <input type="text" class="form-control" id="idx" name="idx" value="${board.idx}" readonly>
			  </div>
	    	
			  <div class="form-group">
			    <label>Title</label>
			    <input type="text" class="form-control" name="title" value="${board.title}">
			  </div>
			  
			  <div class="form-group">
			    <label>Text area</label>
			    <textarea class="form-control" rows="7" name="contents"> ${board.contents} </textarea>
			  </div>
			  
			  <div class="form-group">
			    <label>Writer</label>
			    <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
			  </div>
			  
			  <button type="submit" class="btn btn-primary">modify</button>
			  <button id="remove" type="button" class="btn btn-danger">Remove</button>
			  <button id="list" type="button" class="btn btn-default">List</button>
			  
			</form>
	    	
	    </div>
	    
	    <div class="panel-footer">취업했단 마인드컨트롤</div>
	    
	  </div>
	  
	</div>

</body>
</html>
