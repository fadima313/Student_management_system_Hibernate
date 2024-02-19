package com.ums.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity(name="T_Classes")
public class Classe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private String libelle;
	
	@OneToMany(mappedBy = "classe")
	protected List<Etudiant> etudiants = new ArrayList<>();
	
	@ManyToMany(mappedBy = "classes")
	protected List<Enseignant> enseignants = new ArrayList<>();

	public Classe(String libelle) {
		this.libelle = libelle;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public List<Etudiant> getEtudiants() {
		return etudiants;
	}


	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	

	public List<Enseignant> getEnseignants() {
		return enseignants;
	}
	

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}
	
	public void remove() {
		etudiants.forEach(etudiant -> etudiant.setClasse(null));
	}
	
	@Override
    public String toString() {
        return "Classe { " +
                "id=" + id +
                ", libelle=" + libelle +
                " }";
    }
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		
		if(obj == null || getClass() != obj.getClass()) return false;
		
		Classe classe = (Classe)obj;
		
		return Objects.equals(id, classe.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
