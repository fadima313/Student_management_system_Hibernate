package com.ums.factories;

import com.ums.db.dao.EnseignantHibernateDaoImpl;

public class EnseignantFactory extends AbstractFactory {
	
	public EnseignantFactory() {}

	@Override
	public EnseignantHibernateDaoImpl getEnseignantDao (Class<? extends EnseignantHibernateDaoImpl> typeDao) {
		if ( typeDao == null ) {
			return null;
		}
		
		if (typeDao == EnseignantHibernateDaoImpl.class) {
			return new EnseignantHibernateDaoImpl ();
		} 
		
		return null;
	}
}
