package tomus.guestbooktest.step2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tomus.guestbooktest.entity.Comment;

public class GuestBookServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp);
	}
	
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	  String userName = req.getParameter("name");
	  String comment = req.getParameter("comment");
	  
	  HttpSession session = req.getSession();
	  List<Comment> comments = (List<Comment>) session.getAttribute("comments");
	  if(comments == null){
		  comments = new ArrayList<Comment>();
	  }
	  
	  if(userName != null && comment != null){
		  comments.add(new Comment(userName, comment));
		  session.setAttribute("comments", comments);
	  }
	  req.setAttribute("comments", comments);
	  
	  String url="/guestBook.jsp";
	  ServletContext sc = getServletContext();
	  RequestDispatcher rd = sc.getRequestDispatcher(url);
	  rd.forward(req, resp);
  }
}
