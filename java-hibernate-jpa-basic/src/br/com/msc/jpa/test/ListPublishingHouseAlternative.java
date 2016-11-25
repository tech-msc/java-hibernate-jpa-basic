package br.com.msc.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.msc.jpa.PublishingHouseRepositoryAlternative;

public class ListPublishingHouseAlternative {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		PublishingHouseRepositoryAlternative phr = new PublishingHouseRepositoryAlternative(emf, em);
		phr.openSession();
		System.out.println("Result: " + phr.findAll());
		phr.realizeTransaction();
		phr.CloseSessions();

	}
}
