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

public class LogoutServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp);
	}
	
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	  
	  UserService userService = UserServiceFactory.getUserService();
	  User user = userService.getCurrentUser();
	  	  
	  if(user != null){
		  resp.sendRedirect(userService.createLogoutURL("/"));
		  return;
	  }else{
		  String url="/";
		  ServletContext sc = getServletContext();
		  RequestDispatcher rd = sc.getRequestDispatcher(url);
		  rd.forward(req, resp);
	  }
  }
}
