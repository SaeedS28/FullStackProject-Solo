package com.saeeds28.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saeeds28.model.Address;
import com.saeeds28.model.Item;
import com.saeeds28.model.PurchaseOrder;
import com.saeeds28.model.User;
import com.saeeds28.repository.CheckoutRepo;
import com.saeeds28.repository.ItemRepo;
import com.saeeds28.repository.UserRepo;

@Component
public class DataLoader {
	
	@Autowired
	UserRepo ur;
	@Autowired
	ItemRepo ir;
	@Autowired
	CheckoutRepo por;
	
	@PostConstruct
	public void addData() {
		Address a = new Address("saeeds28", "130 Adelaide W", "Toronto", "Ontaio", "Canada", "M5H3P5");
		Address a2 = new Address("samad", "4700 Keele Street", "Toronto", "Ontaio", "Canada", "M3J1P3");

		// Users
		User u = new User("saeeds28", DigestUtils.sha256Hex("bluejays123"), "Saad", "Saeed", "admin", UserStatus.ACTIVE.toString(), a);
		User u2 = new User("samad", DigestUtils.sha256Hex("password"), "Samad", "Saeed", "regular", UserStatus.ACTIVE.toString(), a2);

		// Items
		List<Item> strawberry = new ArrayList<>();
		strawberry.add(new Item("Boots", "Clothing", "They cover your feet from the cold and wet", 32, 12.99));
		strawberry.add(new Item("Google Pixel Phone", "Technology", "It's a phone fam", 12, 699.99));
		strawberry.add(new Item("Water Bottle", "Essentials", "You can smuggle your alcohol now", 42, 5.99));
		strawberry.add(new Item("Baseballs", "Sports", "You can now bash people with 95 mph fastball", 32, 4.99));
		strawberry.add(new Item("Glasses", "Health", "Make blind people see", 45, 199.99));
		strawberry.add(new Item("Surface Pro 7", "Technology", "Latest and greatest computer so far", 12, 2099.99));
		strawberry.add(new Item("Chocolate Bars", "Food/Beverage", "Dan will eat these in a flash", 85, 3.99));
		strawberry.add(
				new Item("Mango Pudding", "Food/Beverage", "Dan will defintely eat these in a heartbeat", 50, 0.99));
		strawberry.add(new Item("Jackets", "Clothing", "Leather jacket to keep you warm", 30, 69.99));
		strawberry.add(new Item("Laniard", "Clothing", "Good for keeping your IDs in view", 32, 8.99));
		strawberry.add(new Item("Wooden Table", "Furniture", "It's a table made of dark maple wood", 32, 69.69));
		strawberry.add(new Item("We are not your kind", "Music", "Slipknot's latest album. It's dank", 32, 39.99));
		strawberry.add(new Item("Lightbulb", "Utility", "Only one person required to screw this one in", 72, 2.99));
		strawberry.add(new Item("Pirated Movies", "Illegal", "Assorted bunch to choose from", 420, 2.99));
		strawberry.add(new Item("Spiked Baseball bats", "Illegal",
				"We are not liable for any damage. Oh, they pop heads.", 32, 42.99));
		strawberry.add(new Item("Pizza", "Food/Beverage", "Something definitely ain't right here", 45, 12.99));
		
		List<PurchaseOrder> po = new ArrayList<>();
		po.add(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),"samad",3,4,5.99));
		po.add(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),"samad",2,1,699.99));
		po.add(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),"samad",4,3,4.99));
		po.add(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),"samad",6,1,2099.99));
		po.add(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),"samad",5,2,199.99));
		po.add(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),"samad",9,1,69.99));
		po.add(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),"samad",11,1,69.69));
		po.add(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),"samad",12,1,49.99));
		po.add(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),"samad",14,16,2.99));
		po.add(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),"samad",16,3,12.99));
		po.add(new PurchaseOrder(new Timestamp(System.currentTimeMillis()),"samad",2,1,699.99));
		
		///////////////  UNCOMMENT IF RUNNING THE APPLICATION FOR THE FIRST TIME OR IF DATABASE FLUSHES  /////////////// 
//		por.saveAll(po);
//		ir.saveAll(strawberry);
//		ur.save(u2);
//		ur.save(u);
	}
}
