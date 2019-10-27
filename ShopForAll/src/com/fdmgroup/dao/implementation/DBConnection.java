package com.fdmgroup.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnection {
	private static String JPA_UNIT_NAME;
	private static DBConnection connection = null;
	private EntityManagerFactory emf;
	
	private DBConnection() {
		super();
		init();
	}
	

	public static String getJPA_UNIT_NAME() {
		return JPA_UNIT_NAME;
	}


	public static void setJPA_UNIT_NAME(String jPA_UNIT_NAME) {
		JPA_UNIT_NAME = jPA_UNIT_NAME;
	}


	private void init() {
		if(emf == null || !emf.isOpen()) {
			emf = Persistence.createEntityManagerFactory(JPA_UNIT_NAME);
		}
	}
	
	public static DBConnection getInstance() {
		if (connection == null) {
			connection = new DBConnection();
		}
		return connection;
	}
	
	public EntityManager getEntityManger() {
		init();
		return emf.createEntityManager();
	}
	
	public void close() {
		emf.close();
	}
}
