package com.ums.factories;

import com.ums.db.dao.EtudiantHibernateDaoImpl;

public class EtudiantFactory extends AbstractFactory {

	public EtudiantFactory() {}

	@Override
	public EtudiantHibernateDaoImpl getEtudiantDao (Class<? extends EtudiantHibernateDaoImpl> typeDao) {
		if ( typeDao == null ) {
			return null;
		}
		
		if (typeDao == EtudiantHibernateDaoImpl.class) {
			return new EtudiantHibernateDaoImpl ();
		} 
		
		return null;
	}
}
