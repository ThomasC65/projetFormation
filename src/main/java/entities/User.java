package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id = null;
	
	private String name;
	private String lastname;
	private Integer agence;
	private Float nbjours;
	private String formation;
	private String lieuFormation;
	private String organisme;
	
	public User(){
		
	}
	
	
	
	public String getLieuFormation() {
		return lieuFormation;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getAgence() {
		return agence;
	}
	public void setAgence(Integer agence) {
		this.agence = agence;
	}
	public Float getNbjours() {
		return nbjours;
	}
	public void setNbjours(Float nbjours) {
		this.nbjours = nbjours;
	}
	public String getFormation() {
		return formation;
	}
	public void setFormation(String formation) {
		this.formation = formation;
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
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", agence=" + agence + ", nbjours="
				+ nbjours + ", formation=" + formation + ", lieuFormation=" + lieuFormation + ", organisme=" + organisme
				+ "]";
	}
	
	
	
	
	
	
	
	
	

}
