package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class DemandeFormation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idFormation = null;

	@ManyToOne
	User user;

	@ManyToOne
	Formation formation;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
