package com.saeeds28.config.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.config.model.Item;
import com.saeeds28.config.repository.ItemRepo;

@Service
public class ItemService {
	
	@Autowired
	ItemRepo ir;
	
	public List<Item> getTopTenPurchasedItems(){
		List<Integer> id = ir.getTopPurchasedItemsProductID();
		
		List<Item> topTenPurchases = new ArrayList<>();
		
		for(int i=0; i < 10; i++) {
			topTenPurchases.add(ir.findById(id.get(i)).orElse(null));
		}
		return topTenPurchases;
	}
	
	public Item getItemById(int productID) {
		return ir.findById(productID).orElse(null);
	}
	
	public List<String> getProductCategories(){
		return ir.getProductCategory();
	}
	
	public List<Item> getAllItems(){
		return ir.findAll();
	}
	
	public List<Item> getItemsByName(String name){
		String productName = "%" + name.toUpperCase() + "%";
		return ir.getItemsByName(productName);
	}
	
	public List<Item> getItemsByPriceRange(double low, double high){
		return ir.getItemsInPriceRange(low, high);
	}
	
	public List<Item> getItemsByCategory(String category){
		category = category.toUpperCase();
		return ir.getItemsByCategory(category);
	}
	
	public void addQuantity(int productId, int quantity) {
		Item item = ir.findById(productId).orElse(null);
		
		if(item != null) {
			item.setQuantity(item.getQuantity() + quantity);
			ir.save(item);
		}
	}
	
	public void changePrice(int productId, double price) {
		Item item = ir.findById(productId).orElse(null);
		
		if(item != null) {
			item.setPrice(price);
			ir.save(item);
		}
	}
}
