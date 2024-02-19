package com.ums.factories;

import com.ums.db.dao.ModuleHibernateDaoImpl;

public class ModulFactory extends AbstractFactory {
	
	public ModulFactory() {}

	@Override
	public ModuleHibernateDaoImpl getModuleDao (Class<? extends ModuleHibernateDaoImpl> typeDao) {
		if ( typeDao == null ) {
			return null;
		}
		
		if (typeDao == ModuleHibernateDaoImpl.class) {
			return new ModuleHibernateDaoImpl ();
		} 
		
		return null;
	}
}
