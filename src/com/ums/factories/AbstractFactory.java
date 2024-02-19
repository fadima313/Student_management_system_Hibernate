package com.ums.factories;

import com.ums.db.dao.BulletinHibernateDaoImpl;
import com.ums.db.dao.ClasseHibernateDaoImpl;
import com.ums.db.dao.EnseignantHibernateDaoImpl;
import com.ums.db.dao.EtudiantHibernateDaoImpl;
import com.ums.db.dao.ModuleHibernateDaoImpl;
import com.ums.db.dao.NoteHibernateDaoImpl;
import com.ums.db.dao.ObjectHibernateDaoImpl;
import com.ums.db.dao.ReleveHibernateDaoImpl;

public class AbstractFactory {
	
public AbstractFactory() { }
	
	public ClasseHibernateDaoImpl getClasseDao (Class<? extends ClasseHibernateDaoImpl> typeDao) {
		return null ;
	}
	
	public EtudiantHibernateDaoImpl getEtudiantDao (Class<? extends EtudiantHibernateDaoImpl> typeDao) {
		return null ;
	}
	
	public NoteHibernateDaoImpl getNoteDao (Class<? extends NoteHibernateDaoImpl> typeDao) {
		return null ;
	}
	
	public ReleveHibernateDaoImpl getReleveDao (Class<? extends ReleveHibernateDaoImpl> typeDao) {
		return null ;
	}
	
	public BulletinHibernateDaoImpl getBulletinDao (Class<? extends BulletinHibernateDaoImpl> typeDao) {
		return null ;
	}
	
	public EnseignantHibernateDaoImpl getEnseignantDao (Class<? extends EnseignantHibernateDaoImpl> typeDao) {
		return null ;
	}
	
	public ModuleHibernateDaoImpl getModuleDao (Class<? extends ModuleHibernateDaoImpl> typeDao) {
		return null ;
	}
	
	public ObjectHibernateDaoImpl getObjectHibernateDao (Class<? extends ObjectHibernateDaoImpl> typeDao) {
		return null ;
	}
}
