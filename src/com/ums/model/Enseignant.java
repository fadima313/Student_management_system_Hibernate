package com.ums.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity(name="T_Enseignants")
public class Enseignant extends Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//public final static Logger logger = LogManager.getLogManager().;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	protected List<Classe> classes = new ArrayList<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	protected List<Modul> modules = new ArrayList<>();
	
	public Enseignant() {}
	
	public Enseignant(String nom, String prenom) {
		super(nom, prenom);
	}
	
	public void add(Classe classe) {
		 classes.add(classe);
		 classe.getEnseignants().add(this);
	}
	
	@Override
    public String toString() {
        return "Enseignant { " +
                "id=" + id +
                ", nom=" + nom +
                ", prenom=" + prenom +
                " }";
    }
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this) return true;
		
		if(obj == null || getClass() != obj.getClass()) return false;
		
		Enseignant enseignant = (Enseignant)obj;
		
		return Objects.equals(id, enseignant.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
