package tomus.guestbooktest.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;


public class CommentEntity extends Comment {
	private Entity googleEntity;
	
	public CommentEntity(String author, String comment){
		super(author, comment);
		
		googleEntity = new Entity(KeyFactory.createKey("Comment", id));
		googleEntity.setProperty("id", this.id);
		googleEntity.setProperty("name", this.author);
		googleEntity.setProperty("comment", this.comment);
	}
	
	public CommentEntity(long id, String author, String comment){
		super(id, author, comment);
		
		googleEntity = new Entity(KeyFactory.createKey("Comment", id));
		googleEntity.setProperty("id", this.id);
		googleEntity.setProperty("name", this.author);
		googleEntity.setProperty("comment", this.comment);
	}
	
	public Entity getGoogleEntity(){
		return googleEntity;
	}
}
