package com.fdmgroup.app;

import java.util.Scanner;

import com.fdmgroup.controller.AuthenticationController;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.dao.implementation.AddressDAO;
import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.dao.implementation.UserDAO;
import com.fdmgroup.dao.interfaces.IAddressDao;
import com.fdmgroup.dao.interfaces.IItemDAO;
import com.fdmgroup.model.Address;
import com.fdmgroup.model.Item;
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
		
		IItemDAO del = new ItemDAO();
		//Item dummyItem = new Item(del.getMaxPid(),"50 Shades of Gray","Books","why do I keep doing this?",52,32.21);
		//del.addItem(dummyItem);
		//del.updateQuantity(1, 12);
		//del.updatePrice(2, 12.34);
		//del.updateName(1, "Maple Baseball bat");
		//del.updateDescription(2, "WHYYYYY?????????????");
		del.updateCategory(2, "Literotica");
	}
}









