package tomus.guestbooktest.step1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestBookServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String url="/guestBook.jsp";
		  ServletContext sc = getServletContext();
		  RequestDispatcher rd = sc.getRequestDispatcher(url);

		  rd.forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	  String userName = req.getParameter("name");
	  String comment = req.getParameter("comment");
		  
	  if(userName != null && comment != null){
		  req.setAttribute("name", userName);
		  req.setAttribute("comment", comment);
	  }
	  
	  String url="/guestBook.jsp";
	  ServletContext sc = getServletContext();
	  RequestDispatcher rd = sc.getRequestDispatcher(url);
	  rd.forward(req, resp);
  }
}
