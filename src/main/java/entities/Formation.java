package entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idFormation = null;

	private BigDecimal nbjours;
	private String formation;
	private String lieuFormation;
	private String organisme;
	private Date dateReel;
	private Date dateAttendue;

	public Integer getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Integer idFormation) {
		this.idFormation = idFormation;
	}

	public Formation() {

	}

	public BigDecimal getNbjours() {
		return nbjours;
	}

	public void setNbjours(BigDecimal nbjours) {
		this.nbjours = nbjours;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public String getLieuFormation() {
		return lieuFormation;
	}

	public void setLieuFormation(String lieuFormation) {
		this.lieuFormation = lieuFormation;
	}

	public String getOrganisme() {
		return organisme;
	}

	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	}

	@Override
	public String toString() {
		return "Formation [id=" + idFormation + ", dateReel=" + dateReel + ", nbjours=" + nbjours + ", formation="
				+ formation + ", lieuFormation=" + lieuFormation + ", organisme=" + organisme + "]";
	}

	public Date getDateReel() {
		return dateReel;
	}

	public void setDateReel(Date dateReel) {
		this.dateReel = dateReel;
	}

	public Date getDateAttendue() {
		return dateAttendue;
	}

	public void setDateAttendue(Date dateAttendue) {
		this.dateAttendue = dateAttendue;
	}

}
