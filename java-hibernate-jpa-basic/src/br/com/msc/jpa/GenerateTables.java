package br.com.msc.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenerateTables {
	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory(EntitiesMapped.PUBLISHINGHOUSE_PU);
		emf.close();

	}
}
