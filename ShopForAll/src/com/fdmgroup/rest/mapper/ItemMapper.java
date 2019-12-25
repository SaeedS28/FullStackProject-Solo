package com.fdmgroup.rest.mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fdmgroup.dao.implementation.ItemDAO;
import com.fdmgroup.dao.implementation.PurchaseOrderDAO;
import com.fdmgroup.model.Item;


public class ItemMapper {
	ApplicationContext context;
	ItemDAO id;
	PurchaseOrderDAO pod;
	
	public ItemMapper() {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		id = context.getBean(ItemDAO.class); 
		pod = context.getBean(PurchaseOrderDAO.class); 
	}
	
	public List<Item> getAllItems(){
		return id.getAllItems();
	}

	public List<Item> getTopItems() {
		return pod.retrieveTopTenPurchases();
	}

	public Item getItemByProductID(int pid) {
		return id.getItemByPid(pid);
	}
}
