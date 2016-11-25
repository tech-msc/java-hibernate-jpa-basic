package br.com.msc.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.msc.jpa.EntitiesMapped;
import br.com.msc.jpa.PublishingHouseRepository;
import br.com.msc.model.PublishingHouse;

public class InsertPublishingHouse {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(EntitiesMapped.PUBLISHINGHOUSE_PU);
		EntityManager em = emf.createEntityManager();
		PublishingHouseRepository phr = new PublishingHouseRepository(em);
		
		PublishingHouse ph = new PublishingHouse();
		ph.setName("affdaijdadadazin");
		ph.setEmail("affdadazdin@mail");
		phr.Add(ph);
		
		em.getTransaction().begin();
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
