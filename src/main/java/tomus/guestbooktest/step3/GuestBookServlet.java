package tomus.guestbooktest.step3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;

public class GuestBookServlet extends HttpServlet {
	private static Key guestbookKey = KeyFactory.createKey("guestbook", "tomusGuestbook");
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		doPost(req, resp);
	}
	
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
	  String userName = req.getParameter("name");
	  String comment = req.getParameter("comment");
	  
	  DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	  
	  if(userName != null && comment != null){
		  Entity commentEntity = new Entity("Comment", guestbookKey);
		  commentEntity.setProperty("name", userName);
		  commentEntity.setProperty("comment", comment);
		  datastore.put(commentEntity);
	  }
	  
	  Query query = new Query("Comment", guestbookKey);
	  List<Entity> comments = datastore.prepare(query).
			  asList(FetchOptions.Builder.withDefaults());
//	  System.out.println();
	  req.setAttribute("comments", comments);
	  
	  String url="/guestBook.jsp";
	  ServletContext sc = getServletContext();
	  RequestDispatcher rd = sc.getRequestDispatcher(url);
	  rd.forward(req, resp);
  }
}
