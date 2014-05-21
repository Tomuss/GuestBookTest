package tomus.guestbooktest.step4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tomus.guestbooktest.entity.CommentEntity;
import tomus.guestbooktest.services.CommentService;

public class DeleteServlet extends HttpServlet {
	
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	  req.setAttribute("comments", CommentService.getAllcomments());
	  
	  String url="/guestBook.jsp";
	  ServletContext sc = getServletContext();
	  RequestDispatcher rd = sc.getRequestDispatcher(url);
	  rd.forward(req, resp);
  }
	
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	  
	  long id = Long.parseLong((String) req.getParameter("id"));
	  CommentService.deleteComment(id);
	  
	  req.setAttribute("comments", CommentService.getAllcomments());
	  
	  String url="/admin.jsp";
	  ServletContext sc = getServletContext();
	  RequestDispatcher rd = sc.getRequestDispatcher(url);
	  rd.forward(req, resp);
  }
}
