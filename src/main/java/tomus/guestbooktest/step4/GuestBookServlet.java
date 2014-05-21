package tomus.guestbooktest.step4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreServiceFactory;

import tomus.guestbooktest.entity.CommentEntity;
import tomus.guestbooktest.services.CommentService;

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
	  	  
	  if(userName != null && comment != null){
		  CommentEntity commentEntity = new CommentEntity(userName, comment);
		  CommentService.persist(commentEntity);
	  }

	  req.setAttribute("comments", CommentService.getAllcomments());
	  
	  String url="/guestBook.jsp";
	  ServletContext sc = getServletContext();
	  RequestDispatcher rd = sc.getRequestDispatcher(url);
	  rd.forward(req, resp);
  }
}
