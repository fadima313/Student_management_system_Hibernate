package com.ums;

import com.ums.db.dao.ObjectHibernateDaoImpl;
import com.ums.exception.DAOException;
import com.ums.factories.ConcreteFactory;
import com.ums.factories.HibernateFactory;
import com.ums.model.Bulletin;
import com.ums.model.Classe;
import com.ums.model.Enseignant;
import com.ums.model.Etudiant;
import com.ums.model.Modul;
import com.ums.model.Note;
import com.ums.model.Releve;

public class Test {
	public Test () {}
	
	/*
	 * 
	 * Creation
	 * 
	 */
	
	public static void ajouterObject( Object entity) throws DAOException {
		ObjectHibernateDaoImpl hibernateDao  = ConcreteFactory.getFactory(HibernateFactory.class)
				.getObjectHibernateDao(ObjectHibernateDaoImpl.class);
		
		hibernateDao.create(entity);
	}
	
	public static void ajouterUnNouvelEtudiant(String nom, String prenom) throws DAOException {
		Etudiant etudiant = new Etudiant(nom, prenom);
		
		ajouterObject(etudiant);
	}
	
	public static void ajouterUnNouvelEnseignant(String nom, String prenom) throws DAOException {
		Enseignant enseignant = new Enseignant(nom, prenom);
		
		ajouterObject(enseignant);
	}
	
	public static Classe creerClasse(String libelle) throws DAOException {
		Classe classe = new Classe(libelle);
		ajouterObject(classe);
		return classe;
	}
	
	public static Etudiant creerEtudiant(String nom, String prenom, Classe classe, Bulletin bulletin) throws DAOException {
		Etudiant etudiant = new Etudiant(nom, prenom);
		etudiant.setClasse(classe);
		etudiant.setBulletin(bulletin);
		
		ajouterObject(etudiant);
		return etudiant;
	}
	
	public static Note creerNote(double value, String commentaire, Releve releve) throws DAOException {
		Note note = new Note(value, commentaire);
		note.setReleve(releve);
		ajouterObject(note);
		return note;
	}
	
	public static Releve creerReleve(double moyenne, Bulletin bulletin) throws DAOException {
		Releve releve = new Releve(moyenne);
		releve.setBulletin(bulletin);
		ajouterObject(releve);
		return releve;
	}
	
	public static Bulletin creerBulletin(int rang, double moyenne) throws DAOException {
		Bulletin bulletin = new Bulletin(rang, moyenne);
		ajouterObject(bulletin);
		return bulletin;
	}
	
	public static Modul creerModule(String libelle, int volume, String objectif) throws DAOException {
		Modul modul = new Modul(libelle, volume, objectif);
		ajouterObject(modul);
		return modul;
	}
	
	public static void creerModule(Modul module) throws DAOException {
		ajouterObject(module);
		return;
	}
	
	public static void creerEnseignant(Enseignant enseignant) throws DAOException {
		ajouterObject(enseignant);
		return;
	}
	
	/*
	 * 
	 * Recherche
	 * 
	 */
	
	public static Classe rechercherUneClasse(int objectId, Class<?> entityClass) throws DAOException {
		ObjectHibernateDaoImpl hibernateDao  = ConcreteFactory.getFactory(HibernateFactory.class)
				.getObjectHibernateDao(ObjectHibernateDaoImpl.class);
		
		Classe classe = (Classe) hibernateDao.read(objectId);
		return classe;
	}
	
	
	/*
	 * 
	 * Suppression
	 * 
	 */
	
	public static void deleteObject(int objectId, Class<?> entityClass) throws DAOException {
		ObjectHibernateDaoImpl hibernateDao  = ConcreteFactory.getFactory(HibernateFactory.class)
				.getObjectHibernateDao(ObjectHibernateDaoImpl.class);
		
		hibernateDao.delete(objectId, entityClass);
		hibernateDao.delete(objectId);
	}
	
	public static void supprimerUneClasse(int classeId) throws DAOException {
		Classe classe = (Classe) rechercherUneClasse(classeId, Classe.class);
		if(classe != null) {
			classe.remove();
		}
	}
}
