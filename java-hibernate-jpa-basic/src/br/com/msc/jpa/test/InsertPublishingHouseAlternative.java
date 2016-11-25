package br.com.msc.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.msc.jpa.PublishingHouseRepositoryAlternative;
import br.com.msc.model.PublishingHouse;

public class InsertPublishingHouseAlternative {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		PublishingHouseRepositoryAlternative phr = 
				new PublishingHouseRepositoryAlternative(emf, em);
	
		PublishingHouse ph = new PublishingHouse();
		ph.setName("House Of Code");
		ph.setEmail("houseofcode@localhost.com");
		
		phr.insert(ph);
		phr.realizeTransaction();
		phr.CloseSessions();
		
				
	}

}
