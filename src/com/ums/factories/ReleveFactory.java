package com.ums.factories;

import com.ums.db.dao.ReleveHibernateDaoImpl;

public class ReleveFactory extends AbstractFactory {

	public ReleveFactory() {}
	
	@Override
	public ReleveHibernateDaoImpl getReleveDao (Class<? extends ReleveHibernateDaoImpl> typeDao) {
		if ( typeDao == null ) {
			return null;
		}
		
		if (typeDao == ReleveHibernateDaoImpl.class) {
			return new ReleveHibernateDaoImpl ();
		} 
		
		return null;
	}
}
