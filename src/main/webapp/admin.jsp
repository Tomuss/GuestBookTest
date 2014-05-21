<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="tomus.guestbooktest.entity.Comment" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>GuestBook Admin</title>
</head>
<body>
	<h1>Welcome to Tomus's GuestBook administrator page!</h1>
	
	<table border="1">
		<tr><td>Name</td><td>Comment</td></tr>
	<%  List<Comment> comments = (List<Comment>) request.getAttribute("comments");
		if(comments != null){
			for(Comment comment : comments){
				out.println("<tr>");
				out.println("<td><p>"+comment.getAuthor()+"</p></td>");
				out.println("<td><p>"+comment.getComment()+"</p></td>");
				out.println("<td><form action=\"edit\" method=\"get\">");
				out.println("<input type=\"hidden\" name=\"id\" value=\""+comment.getId()+"\">");
				out.println("<input type=\"submit\" value=\"edit\"></form></td>");
				out.println("<td><form action=\"delete\" method=\"post\">");
				out.println("<input type=\"hidden\" name=\"id\" value=\""+comment.getId()+"\">");
				out.println("<input type=\"submit\" value=\"delete\"></form></td>");
				out.println("</tr>");
			}
		}
	%>
	</table>
	<br/>
	<a href="/">Post New Comments!</a>
	<br/>
	<a href="/logout">Logout</a>
</body>
</html>