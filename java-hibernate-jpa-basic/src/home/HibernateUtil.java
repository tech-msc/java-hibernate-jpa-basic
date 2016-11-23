package home;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private EntityManagerFactory emf;

	protected void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa_test-pu");
	}

	protected void tearDown() throws Exception {
		emf.close();
	}

	public void testBasicList() {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		List<PublishHouseHibernate> result = em
				.createQuery("from PublishHouseHibernate",
						PublishHouseHibernate.class)
				.getResultList();

		for (PublishHouseHibernate pb : result) {
			
			System.out.println(
					"PublishHouse: Name: " + pb.getName() + ", Email: " + pb.getEmail());
		}

		em.getTransaction().commit();
		em.clear();
		em.clear();

	}

	// public void testBasicInsert() {
	public void testBasicInsert(String name, String email) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(new PublishHouseHibernate(name, email));
		em.getTransaction().commit();
		System.out.println("Insert realized... :)");
		em.clear();
		em.close();

	}

}
