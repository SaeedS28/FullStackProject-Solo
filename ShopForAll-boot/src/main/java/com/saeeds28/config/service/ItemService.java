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
		
		for(int i=0; i<10;i++) {
			topTenPurchases.add(ir.findById(id.get(i)).orElse(null));
		}
		return topTenPurchases;
	}
}