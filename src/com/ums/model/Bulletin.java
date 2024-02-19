package com.ums.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name="T_Bulletins")
public class Bulletin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_bulletin")
	private int id;
	
	private int rang;
	private double moyenne;
	
	@OneToMany(mappedBy = "bulletin", cascade= {CascadeType.PERSIST})
	protected List<Releve> releves = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name="etudiant_id")
	private Etudiant etudiant;
	
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Bulletin(int rang, double moyenne) {
		// TODO Auto-generated constructor stub
		this.rang = rang;
		this.moyenne = moyenne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	public List<Releve> getReleves() {
		return releves;
	}

	public void setReleves(List<Releve> releves) {
		this.releves = releves;
	}
	
	@Override
    public String toString() {
        return "Bulletin { " +
                "id=" + id +
                ", rang=" + rang +
                ", moyenne=" + moyenne +
                " }";
    }
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof Bulletin)) return false;
		
		if(this.id == ((Bulletin)obj).getId())
			return true;
		
		return false;
	}

}
