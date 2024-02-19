package com.ums.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ums.dao.IDao;
import com.ums.db.HibernateConnection;
import com.ums.exception.DAOException;
import com.ums.model.Note;
import com.ums.model.Releve;

import jakarta.persistence.Query;

public class ReleveHibernateDaoImpl implements IDao<Releve> {

	@Override
	public void create(Releve entity) throws DAOException {
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
	public Releve read(int id) throws DAOException {
		// TODO Auto-generated method stub
		Releve releve = null;
		try {
			Session session = HibernateConnection.getInstance().getSession();
			releve = session.find(Releve.class, id);
			
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
		return releve;
	}

	@Override
	public List<Releve> list() throws DAOException {
		// TODO Auto-generated method stub
		List<Releve> releves = new ArrayList<>();
		try {
			Session session = HibernateConnection.getInstance().getSession();

			Query query = session.createQuery("From T_Releves");
			releves = query.getResultList();
			//HibernateConnection.getInstance().closeSession();
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
		return releves;
	}

	@Override
	public void update(Releve entity) throws DAOException {
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
			
			Releve releve = read(id);
			if(releve != null) {
				session.delete(releve);
			}
			
			transaction.commit();
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
	}

}
