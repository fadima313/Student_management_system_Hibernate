package com.ums.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name="T_Etudiants")
public class Etudiant extends Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    @JoinColumn(name = "classe_id")
	private Classe classe = null;
	
	@OneToOne (cascade= {CascadeType.PERSIST})
	@JoinColumn(name="bulletin_id")
	private Bulletin bulletin;
	

	public Bulletin getBulletin() {
		return bulletin;
	}


	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
		bulletin.setEtudiant(this);
	}


	public Etudiant(String nom, String prenom) {
		super(nom, prenom);
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	@Override
    public String toString() {
        return "Etudiant { " +
                "id=" + id +
                ", nom=" + nom +
                ", prenom=" + prenom +
                ", classe=" + classe +
                " }";
    }
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof Etudiant)) return false;
		
		if(this.id == ((Etudiant)obj).getId())
			return true;
		
		return false;
	}

}
