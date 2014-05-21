<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>GuestBook</title>
</head>
<body>
	<h1>Welcome to Tomus's GuestBook</h1>
	
	<%  List<Entity> comments = (List<Entity>) request.getAttribute("comments");
		if(comments != null){
			for(Entity comment : comments){
				out.println("<p>"+comment.getProperty("name")+" wrote : <br/>"+comment.getProperty("comment")+"<p>");
			}
		}
	%>
	<h2>Post new comment on my GuestBookk!</h2>
	
	<form action="/comment" method="post">
		<label>name : </label><input type="text" name="name" /><br/>
    	<label>comment : </label><textarea name="comment" rows="2" cols="60" ></textarea><br/>
    	<input type="submit" value="Post Comment"/>
	</form>

</body>
</html>