<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="tomus.guestbooktest.entity.Comment" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>GuestBook Comment edit</title>
</head>
<body>
	<h1>Comment Edition</h1>
	<form action="edit" method="post">
	<%  Comment comment = (Comment) request.getAttribute("comment");
		if(comment != null){
				out.println("<label>name : </label><input type=\"text\" name=\"name\" value=\""
					+comment.getAuthor()+"\" /> <br/>");
				out.println("<label>comment : </label><textarea name=\"comment\" rows=\"2\" cols=\"60\" >"
					+comment.getComment()+"</textarea><br/>");
				out.println("<input type=\"hidden\" name=\"id\" value=\""+comment.getId()+"\">");
		}
	%>
	<input type="submit" value="Edit Comment">
	</form>
</body>
</html>