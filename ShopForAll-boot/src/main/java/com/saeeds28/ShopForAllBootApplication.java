package com.saeeds28;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "com.saeeds28.**")
public class ShopForAllBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShopForAllBootApplication.class, args);
		System.out.println(System.getProperty("user.dir"));
		openHomePage();
	}

	private static void openHomePage() {
		String url = "http://localhost:8080/ShopForAll/";
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(new URI(url));
			} catch (IOException | URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
