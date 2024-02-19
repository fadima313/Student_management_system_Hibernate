package com.ums.factories;

import com.ums.db.dao.ClasseHibernateDaoImpl;

public class ClasseFactory extends AbstractFactory {
	
	public ClasseFactory() {}

	@Override
	public ClasseHibernateDaoImpl getClasseDao (Class<? extends ClasseHibernateDaoImpl> typeDao) {
		if ( typeDao == null ) {
			return null;
		}
		
		if (typeDao == ClasseHibernateDaoImpl.class) {
			return new ClasseHibernateDaoImpl ();
		} 
		
		return null;
	}
}
