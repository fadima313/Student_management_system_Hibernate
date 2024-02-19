package com.ums.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ums.dao.IDao;
import com.ums.db.HibernateConnection;
import com.ums.exception.DAOException;
import com.ums.model.Enseignant;
import com.ums.model.Etudiant;

import jakarta.persistence.Query;

public class EnseignantHibernateDaoImpl implements IDao<Enseignant> {

	@Override
	public void create(Enseignant entity) throws DAOException {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateConnection.getInstance().getSession();
			
			Transaction transaction	= session.beginTransaction();
			
			session.persist(entity);
			
			transaction.commit();
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + " : " + e.getMessage());
		}
	}

	@Override
	public Enseignant read(int id) throws DAOException {
		// TODO Auto-generated method stub
		Enseignant enseignant = null;
		try {
			Session session = HibernateConnection.getInstance().getSession();
			enseignant = session.find(Enseignant.class, id);
			
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
		return enseignant;
	}

	@Override
	public List<Enseignant> list() throws DAOException {
		// TODO Auto-generated method stub
		List<Enseignant> enseignants = new ArrayList<>();
		try {
			Session session = HibernateConnection.getInstance().getSession();

			Query query = session.createQuery("From T_Enseignants");
			enseignants = query.getResultList();
			//HibernateConnection.getInstance().closeSession();
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
		return enseignants;
	}

	@Override
	public void update(Enseignant entity) throws DAOException {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateConnection.getInstance().getSession();
			
			Transaction transaction	= session.beginTransaction();
			session.update(entity);
			transaction.commit();
			
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
	}

	@Override
	public void delete(int id) throws DAOException {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateConnection.getInstance().getSession();
			
			Transaction transaction	= session.beginTransaction();
			
			Enseignant enseignant = read(id);
			if(enseignant != null) {
				session.delete(enseignant);
			}
			
			transaction.commit();
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
	}

}
