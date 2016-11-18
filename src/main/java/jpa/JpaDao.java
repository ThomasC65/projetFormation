package jpa;

import entities.User;

public class JpaDao {

	public void createUser(User u){
		EmFactory.voidTransaction(em -> {
			em.persist(u);
		});
	}
	
}
