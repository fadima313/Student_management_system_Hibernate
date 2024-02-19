package com.ums.factories;

import com.ums.db.dao.BulletinHibernateDaoImpl;

public class BulletinFactory extends AbstractFactory {
	
	public BulletinFactory() {}
	
	@Override
	public BulletinHibernateDaoImpl getBulletinDao (Class<? extends BulletinHibernateDaoImpl> typeDao) {
		if ( typeDao == null ) {
			return null;
		}
		
		if (typeDao == BulletinHibernateDaoImpl.class) {
			return new BulletinHibernateDaoImpl ();
		} 
		
		return null;
	}
}
