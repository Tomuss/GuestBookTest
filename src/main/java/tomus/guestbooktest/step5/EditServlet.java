package tomus.guestbooktest.step5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import tomus.guestbooktest.entity.CommentEntity;
import tomus.guestbooktest.services.CommentService;

public class EditServlet extends HttpServlet {
	
  private void authenticate(HttpServletRequest req, HttpServletResponse resp) throws IOException{
	  UserService userService = UserServiceFactory.getUserService();
	  User user = userService.getCurrentUser();
	  	  
	  if(user == null){
		  resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
		  return;
	  }
  }
	
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	  
	  authenticate(req, resp);
	  
	  String idParameter = (String) req.getParameter("id");
	  long id = -1;
	  if(idParameter != null){
		  id = Long.parseLong(idParameter);
	  }
	  
	  String url;
	  if(idParameter != null){
		  url="/editComment.jsp";
		  req.setAttribute("comment", CommentService.getComment(id));
	  }else{
		  url="/admin.jsp";
		  req.setAttribute("comments", CommentService.getAllcomments());
	  }
	  
	  ServletContext sc = getServletContext();
	  RequestDispatcher rd = sc.getRequestDispatcher(url);
	  rd.forward(req, resp);
  }
	
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	  
	  authenticate(req, resp);

	  
	  long id = Long.parseLong((String) req.getParameter("id"));
	  String userName = req.getParameter("name");
	  String comment = req.getParameter("comment");
	  
	  if(userName != null && comment != null){
		  CommentEntity commentEntity = new CommentEntity(id, userName, comment);
		  CommentService.update(commentEntity);
	  }
	  
	  req.setAttribute("comments", CommentService.getAllcomments());
	  
	  String url="/admin.jsp";
	  ServletContext sc = getServletContext();
	  RequestDispatcher rd = sc.getRequestDispatcher(url);
	  rd.forward(req, resp);
  }
}
