package tomus.guestbooktest.services;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.KeyFactory;

public class IdFactory {
	private static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	
	public static long getIdGenerator(){
		Entity idGenerator = null;
		long idValue = 0;
		try {
			idGenerator = datastore.get(KeyFactory.createKey("IdGenerator", "value"));
			idValue = (Long) idGenerator.getProperty("id");
		} catch (EntityNotFoundException e) {
		}
		
		return idValue;
	}
	
	public static void saveGeneratorValue(long id){
		Entity idGenerator = new Entity(KeyFactory.createKey("IdGenerator", "value"));
		idGenerator.setProperty("id", id);
		datastore.put(idGenerator);
	}

}
