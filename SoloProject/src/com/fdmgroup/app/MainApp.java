package com.fdmgroup.app;

import java.util.Scanner;

import com.fdmgroup.view.HomeView;

public class MainApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//Views
		HomeView hv = new HomeView(scanner);
		hv.showInitialOptions(false);
		
	}
}









