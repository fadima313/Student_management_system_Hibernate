package com.ums;

import java.util.List;

import org.hibernate.Session;

import com.ums.dao.IDao;
import com.ums.db.HibernateConnection;
import com.ums.db.dao.HibernateUserDaoImpl;
import com.ums.exception.DAOException;
import com.ums.model.User;

public class Launcher {


	public static void main(String[] args) {
		
		HibernateConnection hibernateConnection = HibernateConnection.getInstance();
		Session session = hibernateConnection.getSession();
		
		if(session.isOpen()) {
			System.out.println("Hibernate started successfully !");
			
			
			/*
			// Create
			User user = new User("BN", "Ba'Hith", "bn@gmail.com", "123456789", "bnLogin", "bnPassword", Role.USER);
			try {
				IDao<User> dao = new HibernateUserDaoImpl();
				dao.create(user);
				System.out.println("Utilisateur créer : " + user + "...");
			} catch (DAOException e) {
				System.out.println("ERROR # : " + e.getMessage());
			}
			*/
			
			
			try {
				IDao<User> dao = new HibernateUserDaoImpl();
				User user2 = dao.read(3);
				
				List<User> users = dao.list();
				for(User u : users) {
					System.out.println(u);	
				}
				
				if(user2 != null) {
					System.out.println("Utilisateur trouvé : " + user2 + "...");
					
					/*
					// Update
					user2.setLogin("bnLogin");
					dao.update(user2);
					*/
					
					
					// Delete
					// dao.delete(3);
				} else {
					System.out.println("Utilisateur non  trouvé...");	
				}
			} catch (DAOException e) {
				System.out.println("ERROR # : " + e.getMessage());
			}
			
			session.close();
			
		} else {
			System.out.println("Hibernate failed !");
		}

	}

}
