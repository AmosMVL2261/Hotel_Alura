package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("hotel");
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
}
