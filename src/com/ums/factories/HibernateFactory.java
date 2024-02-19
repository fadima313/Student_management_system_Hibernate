package com.ums.factories;

import com.ums.db.dao.ObjectHibernateDaoImpl;

public class HibernateFactory extends AbstractFactory {
	
	public HibernateFactory() {}

	@Override
	public ObjectHibernateDaoImpl getObjectHibernateDao (Class<? extends ObjectHibernateDaoImpl> typeDao) {
		if ( typeDao == null ) {
			return null;
		}
		
		if (typeDao == ObjectHibernateDaoImpl.class) {
			return new ObjectHibernateDaoImpl ();
		} 
		
		return null;
	}
}
