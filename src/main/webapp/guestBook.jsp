<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="tomus.guestbooktest.entity.Comment" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>GuestBook</title>
</head>
<body>
	<h1>Welcome to Tomus's GuestBook</h1>
	
	<%  List<Comment> comments = (List<Comment>) request.getAttribute("comments");
		if(comments != null){
			for(Comment comment : comments){
				out.println("<p>"+comment.getAuthor()+" wrote : <br/>"+comment.getComment()+"<p>");
			}
		}
	%>
	<h2>Post new comment on my GuestBookk!</h2>
	
	<form action="/comment" method="post">
		<label><p>name : </p></label><input type="text" name="name" /><br/>
    	<label><p>comment : </p></label><textarea name="comment" rows="2" cols="60" ></textarea><br/>
    	<input type="submit" value="Post Comment"/>
	</form>
	<br/>
	<a href="admin"><p>Administration page</p></a>
	
</body>
</html>