package com.ums.factories;


public class ConcreteFactory {

	public ConcreteFactory() { }
	
	public static AbstractFactory getFactory (Class<? extends AbstractFactory> factory) {
		if (factory == null) {
			return null;
		}
		
		if (factory == ClasseFactory.class) {
			return new ClasseFactory ();
		} else if (factory == EtudiantFactory.class) {
			return new EtudiantFactory ();
		} else if (factory == NoteFactory.class) {
			return new NoteFactory ();
		} else if (factory == ReleveFactory.class) {
			return new ReleveFactory ();
		} else if (factory == BulletinFactory.class) {
			return new BulletinFactory ();
		} else if (factory == EnseignantFactory.class) {
			return new EnseignantFactory ();
		} else if (factory == ModulFactory.class) {
			return new ModulFactory ();
		} else if (factory == HibernateFactory.class) {
			return new HibernateFactory ();
		}
		
		return null;
	}
}
