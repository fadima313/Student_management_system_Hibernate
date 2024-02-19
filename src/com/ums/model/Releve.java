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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name="T_Releves")
public class Releve implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private double moyenne;
	
	@OneToMany(mappedBy = "releve", cascade= {CascadeType.PERSIST})
	protected List<Note> notes = new ArrayList<>();
	
	@ManyToOne
    @JoinColumn(name = "bulletin_id")
	private Bulletin bulletin = null;
	
	
	public Releve(double moyenne) {
		// TODO Auto-generated constructor stub
		this.moyenne = moyenne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Bulletin getBulletin() {
		return bulletin;
	}

	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}
	
	@Override
    public String toString() {
        return "Bulletin { " +
                "id=" + id +
                ", moyenne=" + moyenne +
                " }";
    }
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof Releve)) return false;
		
		if(this.id == ((Releve)obj).getId())
			return true;
		
		return false;
	}

}
