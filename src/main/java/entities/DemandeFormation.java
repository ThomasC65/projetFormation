package entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class DemandeFormation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idFormation = null;	
	
	@ManyToOne
   	User user;
    
    @ManyToOne
    Formation formation;	
	
	
	
	
}
