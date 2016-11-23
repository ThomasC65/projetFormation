package jpa;

import entities.Formation;
import entities.User;

public class JpaDao {

	public void createUser(User u) {
		EmFactory.voidTransaction(em -> {
			em.persist(u);
		});
	}

	public void createFormation(Formation f) {
		EmFactory.voidTransaction(em -> {
			em.persist(f);
		});
	}

}
