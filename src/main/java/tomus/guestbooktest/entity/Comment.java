package tomus.guestbooktest.entity;

import java.io.Serializable;

import tomus.guestbooktest.services.IdFactory;

import com.google.appengine.api.datastore.Entity;


public class Comment implements Serializable{
	protected static long idGenerator = IdFactory.getIdGenerator();
	
	protected long id;
	protected String author;
	protected String comment;
	
	public Comment(String author, String comment){
		id = ++idGenerator;
		this.author=author;
		this.comment=comment;
	}
	
	public Comment(long id, String author, String comment){
		this.id = id;
		this.author=author;
		this.comment=comment;
	}
	
	public Comment(Entity googleEntity){
		this.id = (Long) googleEntity.getProperty("id");
		this.author = (String) googleEntity.getProperty("name");
		this.comment = (String) googleEntity.getProperty("comment");
	}
	
	public long getId(){
		return id;
	}
	
	public String getAuthor() {
		return author;
	}

	public String getComment() {
		return comment;
	}
	
}
