package com.saeeds28.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saeeds28.exception.ResourceNotFoundException;
import com.saeeds28.model.Item;
import com.saeeds28.service.ItemService;

@RestController
@RequestMapping(path = "items", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemRestController {

	@Autowired
	ItemService is;
	
	@GetMapping
	public List<Item> getAllItems() {
		return is.getAllItems();
	}
	
	@GetMapping(path = "top")
	public List<Item> getTopTenItems() {
		return is.getTopTenPurchasedItems();
	}
	
	@GetMapping(path = "/item/{id}")
	public Item getItemById(@PathVariable int id) {
		Item item = is.getItemById(id);
		if(item == null) {
			throw new ResourceNotFoundException();
		}
		return item;
	}
	
	@GetMapping(path = "/categories")
	public List<String> getCategpries() {
		return is.getProductCategories();
	}
	
	@GetMapping(path = "/categories/{category}")
	public List<Item> getItemsByCategpries(@PathVariable String category) {
		return is.getItemsByCategory(category);
	}
}
	
