package com.ums.factories;

import com.ums.db.dao.NoteHibernateDaoImpl;

public class NoteFactory extends AbstractFactory {
	
	public NoteFactory() {}

	@Override
	public NoteHibernateDaoImpl getNoteDao (Class<? extends NoteHibernateDaoImpl> typeDao) {
		if ( typeDao == null ) {
			return null;
		}
		
		if (typeDao == NoteHibernateDaoImpl.class) {
			return new NoteHibernateDaoImpl ();
		} 
		
		return null;
	}
}
