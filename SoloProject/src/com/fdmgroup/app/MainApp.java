package com.fdmgroup.app;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.model.User;
import com.fdmgroup.view.HomeView;

public class MainApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		EntityManagerFactory emf;
//		EntityManager em;
//		emf = Persistence.createEntityManagerFactory("SoloProject");
//		em = emf.createEntityManager();		
//		User u = new User("saeeds28", "bluejays123", "Saad", "Saeed", "admin");
		
//		
//		em.getTransaction().begin();
//		em.persist(u);
//		em.getTransaction().commit();
//		
//		em.close();
//		emf.close();
//		
		//Views
		HomeView hv = new HomeView(scanner);
		hv.showInitialOptions(false);
		
	}
}