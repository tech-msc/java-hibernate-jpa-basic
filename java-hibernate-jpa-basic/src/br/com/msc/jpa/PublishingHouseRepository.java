package br.com.msc.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.msc.model.PublishingHouse;

public class PublishingHouseRepository {

	private EntityManager entityManager;	

	public PublishingHouseRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void Add(PublishingHouse ph) {
		this.entityManager.persist(ph);
	}

	public PublishingHouse findById(Long id) {
		return this.entityManager.find(PublishingHouse.class, id);
	}

	public List<PublishingHouse> findAll() {
		return this.entityManager.createQuery("FROM PublishingHouse", PublishingHouse.class)
				.getResultList(); 
	}	

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(EntitiesMapped.PUBLISHINGHOUSE_PU);
		EntityManager em = emf.createEntityManager();

		PublishingHouseRepository repo = new PublishingHouseRepository(em);

		String result = repo.findAll().toString();
		System.out.println("Result: \n" + result);

		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		emf.close();

	} 

}
