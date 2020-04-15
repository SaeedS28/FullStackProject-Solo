package com.saeeds28.config;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.saeeds28.config.model.Address;
import com.saeeds28.config.model.User;
import com.saeeds28.config.service.UserService;



@SpringBootApplication
public class ShopForAllBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShopForAllBootApplication.class, args);
		openHomePage();
	}

	private void loadData() {
		Address a = new Address("saeeds28", "130 Adelaide W", "Toronto", "Ontaio", "Canada", "M5H3P5");
		Address a2 = new Address("samad", "25 Telegram Mews", "Toronto", "Ontaio", "Canada", "M5V3Z1");

		// Items
//		List<Item> strawberry = new ArrayList<>();
//		strawberry.add(new Item("Boots", "Clothing", "They cover your feet from the cold and wet", 32, 12.99));
//		strawberry.add(new Item("Google Pixel Phone", "Technology", "It's a phone fam", 12, 699.99));
//		strawberry.add(new Item("Water Bottle", "Essentials", "You can smuggle your alcohol now", 42, 5.99));
//		strawberry.add(new Item("Baseballs", "Sports", "You can now bash people with 95 mph fastball", 32, 4.99));
//		strawberry.add(new Item("Glasses", "Health", "Make blind people see", 45, 199.99));
//		strawberry.add(new Item("Surface Pro 7", "Technology", "Latest and greatest computer so far", 12, 2099.99));
//		strawberry.add(new Item("Chocolate Bars", "Food/Beverage", "Dan will eat these in a flash", 85, 3.99));
//		strawberry.add(
//				new Item("Mango Pudding", "Food/Beverage", "Dan will defintely eat these in a heartbeat", 50, 0.99));
//		strawberry.add(new Item("Jackets", "Clothing", "Leather jacket to keep you warm", 30, 69.99));
//		strawberry.add(new Item("Laniard", "Clothing", "Good for keeping your IDs in view", 32, 8.99));
//		strawberry.add(new Item("Wooden Table", "Furniture", "It's a table made of dark maple wood", 32, 69.69));
//		strawberry.add(new Item("We are not your kind", "Music", "Slipknot's latest album. It's dank", 32, 39.99));
//		strawberry.add(new Item("Lightbulb", "Utility", "Only one person required to screw this one in", 72, 2.99));
//		strawberry.add(new Item("Pirated Movies", "Illegal", "Assorted bunch to choose from", 420, 2.99));
//		strawberry.add(new Item("Spiked Baseball bats", "Illegal",
//				"We are not liable for any damage. Oh, they pop heads.", 32, 42.99));
//		strawberry.add(new Item("Pizza", "Food/Beverage", "Something definitely ain't right here", 45, 12.99));
		
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
