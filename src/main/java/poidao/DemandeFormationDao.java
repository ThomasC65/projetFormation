package poidao;

import java.util.List;

import entities.DemandeFormation;
import entities.Formation;
import entities.User;
import jpa.EmFactory;

public class DemandeFormationDao {

	public DemandeFormation getOrInsertDemandeFormationInDb(DemandeFormation demandeFormation, User user,
			Formation formation) {
		return EmFactory.transaction(em -> {
			List<DemandeFormation> listeDemandeFormation = em
					.createQuery("SELECT df from DemandeFormation df WHERE df.user=:user AND df.formation=:formation",
							DemandeFormation.class)
					.setParameter("user", demandeFormation.getUser())
					.setParameter("formation", demandeFormation.getFormation()).getResultList();

			if (listeDemandeFormation.isEmpty()) {
				em.persist(demandeFormation);
				return demandeFormation;
			} else {
				return listeDemandeFormation.get(0);
			}
		});
	}
}
