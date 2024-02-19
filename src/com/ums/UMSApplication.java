package com.ums;

import com.ums.exception.DAOException;
import com.ums.model.Bulletin;
import com.ums.model.Classe;
import com.ums.model.Enseignant;
import com.ums.model.Etudiant;
import com.ums.model.Note;
import com.ums.model.Releve;

public class UMSApplication {
	
	private static Testeur testeur = new Testeur();
	
	public static void main(String[] args) throws DAOException {
		testerOneToMany();
		testerOneToOne();
		  creerDesEnseignantEtDesClasses();
		try {
		testHeritage();
			
		testerOneToMany();
		testerOneToOne();
			creerDesEnseignantEtDesClasses();
			
			System.out.println("Test fait !");
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error : " + e.getMessage());
		}
	}
	
	private static void testHeritage() throws DAOException {
		Test.ajouterUnNouvelEtudiant("ASCOFARE", "Fadimata");
		Test.ajouterUnNouvelEnseignant("SECK", "Momar Prosper");
	}
	
	
	
	private static void creerDesEnseignantEtDesClasses() throws DAOException {
		Enseignant preira = new Enseignant("PREIRA", "Jean-Marie");
		Enseignant akinocho = new Enseignant("AKINOCHO", "Ghislain");
		
		
		Classe lti_dar = new Classe("LTI-3-DAR");
		Classe m_isi_1_jour = new Classe("MISI-1 Jour");
		Classe m_isi_1_soir = new Classe("MISI-1 Soir");
		
		
		preira.add(lti_dar);
		preira.add(m_isi_1_jour);
		
		akinocho.add(lti_dar);
		akinocho.add(m_isi_1_soir);
		
		Test.creerEnseignant(akinocho);
		Test.creerEnseignant(preira);
		
	}

	private static void testerOneToOne() throws DAOException {
		Classe classe = Test.creerClasse("MP-SSI-1");
		
		Bulletin bulletin = Test.creerBulletin(1, 19.97);

		Etudiant etudiant = Test.creerEtudiant("Souleymane", "KODJO", classe, bulletin);
		bulletin.setEtudiant(etudiant);
		
		Releve releve = testeur.creerReleve(18, bulletin);
		
		Note note_1 = Test.creerNote(15, "Bien", releve);
		Note note_2 = Test.creerNote(17, "Très bien", releve);
		Note note_3 = Test.creerNote(19, "Excellent", releve);
		
		System.out.println("Main program : " + etudiant + " added.");
		
	}
	
	
	private static void testerOneToMany() throws DAOException {
		Bulletin bulletin = testeur.creerBulletin(3, 17.75);
		
		Classe classe = Test.creerClasse("MP-ISI-1");
		Etudiant etudiant = Test.creerEtudiant("Landry", "SANOU", classe, bulletin);
		
		Releve releve = Test.creerReleve(18, bulletin);
		
		Note note_1 = Test.creerNote(15, "Bien", releve);
		Note note_2 = Test.creerNote(17, "Très bien", releve);
		Note note_3 = Test.creerNote(19, "Excellent", releve);
		
		System.out.println("Main program : " + etudiant + " added.");
	}
}
