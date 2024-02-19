package com.ums.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ums.dao.IDao;
import com.ums.db.HibernateConnection;
import com.ums.exception.DAOException;
import com.ums.model.Etudiant;

import jakarta.persistence.Query;

public class EtudiantHibernateDaoImpl implements IDao<Etudiant>{

	@Override
	public void create(Etudiant entity) throws DAOException {
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
	public Etudiant read(int id) throws DAOException {
		// TODO Auto-generated method stub
		Etudiant etudiant = null;
		try {
			Session session = HibernateConnection.getInstance().getSession();
			etudiant = session.find(Etudiant.class, id);
			
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
		return etudiant;
	}

	@Override
	public List<Etudiant> list() throws DAOException {
		// TODO Auto-generated method stub
		List<Etudiant> etudiants = new ArrayList<>();
		try {
			Session session = HibernateConnection.getInstance().getSession();

			Query query = session.createQuery("From T_Etudiants");
			etudiants = query.getResultList();
			//HibernateConnection.getInstance().closeSession();
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
		return etudiants;
	}

	@Override
	public void update(Etudiant entity) throws DAOException {
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
			
			Etudiant etudiant = read(id);
			if(etudiant != null) {
				session.delete(etudiant);
			}
			
			transaction.commit();
		} catch (Exception e) {
			throw new DAOException("ERROR : " + e.getClass() + ":" + e.getMessage());
		}
	}

}
