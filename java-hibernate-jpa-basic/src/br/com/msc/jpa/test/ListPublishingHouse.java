package br.com.msc.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.msc.jpa.EntitiesMapped;
import br.com.msc.jpa.PublishingHouseRepository;

public class ListPublishingHouse {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(EntitiesMapped.PUBLISHINGHOUSE_PU);
		EntityManager em = emf.createEntityManager();
		PublishingHouseRepository phr = new PublishingHouseRepository(em);
		System.out.println("Publishing Houses: \n" + phr.findAll());		
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
