package com.ums.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="T_Notes")
public class Note implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private double value;
	private String commentaire;
	
	@ManyToOne
    @JoinColumn(name = "releve_id")
	private Releve releve = null;

	public Note(double value, String commentaire) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.commentaire = commentaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Releve getReleve() {
		return releve;
	}

	public void setReleve(Releve releve) {
		this.releve = releve;
	}
	
	@Override
    public String toString() {
        return "Bulletin { " +
                "id=" + id +
                ", value=" + value +
                ", commentaire=" + commentaire +
                " }";
    }
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof Note)) return false;
		
		if(this.id == ((Note)obj).getId())
			return true;
		
		
		return false;
	}
	

}
