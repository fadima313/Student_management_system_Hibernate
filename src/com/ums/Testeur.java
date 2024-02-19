package com.ums;

import com.ums.db.dao.BulletinHibernateDaoImpl;
import com.ums.db.dao.ClasseHibernateDaoImpl;
import com.ums.db.dao.EnseignantHibernateDaoImpl;
import com.ums.db.dao.EtudiantHibernateDaoImpl;
import com.ums.db.dao.ModuleHibernateDaoImpl;
import com.ums.db.dao.NoteHibernateDaoImpl;
import com.ums.db.dao.ReleveHibernateDaoImpl;
import com.ums.exception.DAOException;
import com.ums.factories.BulletinFactory;
import com.ums.factories.ClasseFactory;
import com.ums.factories.ConcreteFactory;
import com.ums.factories.EnseignantFactory;
import com.ums.factories.EtudiantFactory;
import com.ums.factories.ModulFactory;
import com.ums.factories.NoteFactory;
import com.ums.factories.ReleveFactory;
import com.ums.model.Bulletin;
import com.ums.model.Classe;
import com.ums.model.Enseignant;
import com.ums.model.Etudiant;
import com.ums.model.Modul;
import com.ums.model.Note;
import com.ums.model.Releve;

public class Testeur {
	
	public Testeur () {}
	
	public Classe creerClasse(String libelle) {
		ClasseHibernateDaoImpl classeDao = ConcreteFactory.getFactory(ClasseFactory.class)
				.getClasseDao(ClasseHibernateDaoImpl.class);
		Classe classe = null;
		
		try {
			classe = new Classe(libelle);
			classeDao.create(classe);
			System.out.println("Une nouvelle classe est ajoutée !");
		} catch (DAOException e) {
			
		}
		
		return classe;
	}
	
	public Etudiant creerEtudiant(String nom, String prenom, Classe classe, Bulletin bulletin) {
		EtudiantHibernateDaoImpl etudiantDao = ConcreteFactory.getFactory(EtudiantFactory.class)
				.getEtudiantDao(EtudiantHibernateDaoImpl.class);
		Etudiant etudiant = null;
		
		try {
			etudiant = new Etudiant(nom, prenom);
			etudiant.setClasse(classe);
			etudiant.setBulletin(bulletin);
			etudiantDao.create(etudiant);
			
			System.out.println("Un nouveau etudiant est ajouté !");
		} catch (DAOException e) {
			
		}
		
		return etudiant;
	}
	
	public Note creerNote(double value, String commentaire, Releve releve) {
		NoteHibernateDaoImpl noteDao = ConcreteFactory.getFactory(NoteFactory.class)
				.getNoteDao(NoteHibernateDaoImpl.class);
		
		Note note = null;
		try {
			note = new Note(value, commentaire);
			note.setReleve(releve);
			noteDao.create(note);
			
			System.out.println("Une nouvelle note est ajoutée !");
		} catch (DAOException e) {
			
		}
		
		return note;
	}
	
	public Releve creerReleve(double moyenne, Bulletin bulletin) {
		ReleveHibernateDaoImpl releveDao = ConcreteFactory.getFactory(ReleveFactory.class)
				.getReleveDao(ReleveHibernateDaoImpl.class);
		
		Releve releve = null;
		try {
			releve = new Releve(moyenne);
			releve.setBulletin(bulletin);
			releveDao.create(releve);
			
			System.out.println("Un nouveau relevé est ajouté !");
		} catch (DAOException e) {
			
		}
		
		return releve;
	}
	
	public Bulletin creerBulletin(int rang, double moyenne) {
		BulletinHibernateDaoImpl bulletinDao = ConcreteFactory.getFactory(BulletinFactory.class)
				.getBulletinDao(BulletinHibernateDaoImpl.class);
		
		Bulletin bulletin = null;
		try {
			bulletin = new Bulletin(rang, moyenne);
			bulletinDao.create(bulletin);
			
			System.out.println("Un nouveau bulletin est ajouté !");
		} catch (DAOException e) {
			
		}
		
		return bulletin;
	}
	
	public Modul creerModule(String libelle, int volume, String objectif) {
		ModuleHibernateDaoImpl moduleDao  = ConcreteFactory.getFactory(ModulFactory.class)
				.getModuleDao(ModuleHibernateDaoImpl.class);
		Modul module = null;
		
		try {
			module = new Modul(libelle, volume, objectif);
			moduleDao.create(module);
			
			System.out.println("Un nouveau module est créé !");
		} catch (DAOException e) {
			
		}
		
		return module;
	}
	
	public void creerModule(Modul module) {
		// TODO Auto-generated method stub
		ModuleHibernateDaoImpl moduleDao  = ConcreteFactory.getFactory(ModulFactory.class)
				.getModuleDao(ModuleHibernateDaoImpl.class);
		try {
			moduleDao.create(module);
			System.out.println("Un nouveau module est ajouté !");
		} catch (DAOException e) {
			
		}
		
	}
	
	public Enseignant creerEnseignant(String nom, String prenom) {
		EnseignantHibernateDaoImpl enseignantDao  = ConcreteFactory.getFactory(EnseignantFactory.class)
				.getEnseignantDao(EnseignantHibernateDaoImpl.class);
		Enseignant enseignant = null;
		
		try {
			enseignant = new Enseignant(nom, prenom);
			enseignantDao.create(enseignant);
			
			System.out.println("Un nouveau enseignant est créee !");
		} catch (DAOException e) {
			
		}
		
		return enseignant;
	}

	public void creerEnseignant(Enseignant enseignant) {
		EnseignantHibernateDaoImpl enseignantDao  = ConcreteFactory.getFactory(EnseignantFactory.class)
				.getEnseignantDao(EnseignantHibernateDaoImpl.class);
		try {
			enseignantDao.create(enseignant);
			System.out.println("Un nouveau enseignant est ajouté !");
		} catch (DAOException e) {
			
		}
		
	}
	

}
