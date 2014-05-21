package tomus.guestbooktest.services;

import java.util.ArrayList;
import java.util.List;

import tomus.guestbooktest.entity.Comment;
import tomus.guestbooktest.entity.CommentEntity;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;

public class CommentService {
	private static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public static void persist(CommentEntity comment){
		  datastore.put(comment.getGoogleEntity());
		  IdFactory.saveGeneratorValue(comment.getId());
	}
	
	public static void update(CommentEntity comment){
		  datastore.put(comment.getGoogleEntity());
	}
	
	public static Comment getComment(long id){
		Entity result = null;
		try {
			result = datastore.get(KeyFactory.createKey("Comment", id));
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Comment(result);
	}
	
	public static List<Comment> getAllcomments(){
		Query query = new Query("Comment");
		List<Entity> datas = datastore.prepare(query).
				  asList(FetchOptions.Builder.withDefaults());
		List<Comment> comments = new ArrayList<Comment>();
		
		for(Entity googleEntity: datas){
			comments.add(new Comment(googleEntity));
		}
		
		return comments;
	}
	
	public static void deleteComment(long id){
		datastore.delete(KeyFactory.createKey("Comment", id));
	}
}
