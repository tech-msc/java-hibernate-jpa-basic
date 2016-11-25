package br.com.msc.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.msc.model.PublishingHouse;

public class PublishingHouseRepositoryAlternative {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;

	public PublishingHouseRepositoryAlternative(EntityManagerFactory emf, EntityManager em) {
		this.entityManagerFactory = emf;
		this.entityManager = em;
		openSession();
	}

	public void openSession() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory(EntitiesMapped.PUBLISHINGHOUSE_PU);
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	public void realizeTransaction() {
		this.entityManager.getTransaction().begin();
		this.entityManager.getTransaction().commit();
	}

	public void CloseSessions() {
		this.entityManager.close();
		this.entityManagerFactory.close();
	}

	// Some CRUD Operations -------------------------------
	// Insert ONE
	public void insert(PublishingHouse ph) {
		this.entityManager.persist(ph);
	}

	// Find by ID
	public PublishingHouse findByID(int id) {
		Long idToFind = (long) id;
		return this.entityManager.find(PublishingHouse.class, idToFind);
	}

	// Find All Elements
	public List<PublishingHouse> findAll() {
		return this.entityManager.createQuery("from PublishingHouse", PublishingHouse.class).getResultList();
	}

	// Find By Email
	public PublishingHouse findByEmail(PublishingHouse ph) {
		PublishingHouse p = new PublishingHouse();
		List<PublishingHouse> result = this.entityManager.createQuery("from PublishingHouse", PublishingHouse.class)
				.getResultList();

		for (PublishingHouse item : result) {
			if (item.getEmail().equals(ph.getEmail())) {
				p = item;
			}
		}
		return p;
	}

	// Update Element
	public void update(int elementIDToUpdate, PublishingHouse ph) {
		
		PublishingHouse toUpdate = findByID(elementIDToUpdate);

		if (ph != null) {
			if (ph.getName() != null)
				toUpdate.setName(ph.getName());

			if (ph.getEmail() != null) {
				toUpdate.setEmail(ph.getEmail());
			}
		}
	}

	// Test update
//	public static void main(String[] args) {
//		EntityManagerFactory emf = null;
//		EntityManager em = null;
//		PublishingHouseRepositoryAlternative repository = new PublishingHouseRepositoryAlternative(emf, em);
//
//		PublishingHouse ph = new PublishingHouse();
//		ph.setName("updated");
//		ph.setEmail("updated");
//		repository.update(7, ph);
//		repository.realizeTransaction();
//		repository.CloseSessions();
//	}

}
