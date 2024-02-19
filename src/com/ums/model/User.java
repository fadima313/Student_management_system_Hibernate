package com.ums.model;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="T_Users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String login;
	private String password;
	private String role;

	public User() {
		this(0, "", "", "", "", "", "", "");
	}
	
	public User(int id, String nom, String prenom, String email, String telephone, String login, String password, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        // login et password par défaut ...
        this.login = login;
        this.password = password;
        this.role = role;
        this.id = id;
    }
	
	public User(String nom, String prenom, String email, String telephone, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        // login et password par défaut ...
        this.login = prenom.trim().toLowerCase() + "." +
        		nom.trim().toLowerCase();
        this.password = "p@Ss3R";
        this.role = role.getRole();
    }
	
	public User(int identifiant, String login, String password) {
		this(login, password);
		this.id = identifiant;
	}
	
	public User(String login, String password) {
		this.password = password;
		this.login = login;
	}
	
	public User(String nom, String prenom, String email, String telephone, String login, String password,
			Role role) {
		this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.login = login;
        this.password = password;
        this.role = role.getRole();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
    public String toString() {
        return "User { " +
                "id=" + id +
                ", nom=" + nom +
                ", prenom=" + prenom +
                ", email=" + email +
                ", telephone=" + telephone +
                ", login=" + login +
                ", password=" + password +
                ", role=" + role +
                " }";
    }
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		
		if(!(obj instanceof User)) return false;
		
		if(this.id == ((User)obj).getId())
			return true;
		
		return false;
	}

}
