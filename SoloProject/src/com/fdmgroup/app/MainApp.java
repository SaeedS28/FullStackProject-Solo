package com.fdmgroup.app;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.dao.implementation.AddressDAO;
import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.dao.interfaces.IAddressDao;
import com.fdmgroup.dao.interfaces.IUserDao;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.User;
import com.fdmgroup.view.DashboardView;
import com.fdmgroup.view.HomeView;

public class MainApp {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		//IUserDao userDao = new UserCollectionDao();
//		IUserDao userDao = new UserDAO();
//		//Views
//		HomeView hv = new HomeView(scanner);
//		DashboardView dv = new DashboardView(scanner);
//		
//		//Controllers
//		HomeController hc = new HomeController();
//		AuthenticationController ac = new AuthenticationController();
//		
//		hc.setHomeView(hv);
//		ac.setDashboardView(dv);
//		ac.setHomeView(hv);
//		ac.setUserDao(userDao);
//		
//		hv.setAuthenticationController(ac);
//		hv.setHomeController(hc);
//		dv.setAuthenticationController(ac);
//		
//		
//		hc.showHome();
//		
//		scanner.close();
		
		//IUserDao del = new UserDAO();
		//User u = new User("sam","sam","Sam","Saeed","admin");
		//del.create(u);
		//del.remove("sam");
		//del.updatePassword(new User("saeeds28","password","Saad","Saeed","admin"), "genericPassword");
		IAddressDao del = new AddressDAO();
		//del.addAddress(new Address("saeeds28","130 Adelaide street","Toronto","ON","Canada","M5H0A1"));
		del.changeCity("Kingston", new User("saeeds28","password","Saad","Saeed","admin"));
	}
}









