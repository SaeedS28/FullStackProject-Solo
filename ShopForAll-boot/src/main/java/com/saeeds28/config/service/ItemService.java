package com.saeeds28.config.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.config.model.Item;
import com.saeeds28.config.repository.ItemRepo;

@Service
public class ItemService {

	@Autowired
	ItemRepo ir;

	public int getHighestProductID() {
		return ir.getMaxPid();
	}
	
	public List<Item> getTopTenPurchasedItems() {
		List<Integer> id = ir.getTopPurchasedItemsProductID();

		List<Item> topTenPurchases = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			topTenPurchases.add(ir.findById(id.get(i)).orElse(null));
		}
		return topTenPurchases;
	}

	public Item getItemById(int productID) {
		return ir.findById(productID).orElse(null);
	}

	public List<String> getProductCategories() {
		return ir.getProductCategory();
	}

	public List<Item> getAllItems() {
		return ir.findAll();
	}

	public List<Item> getItemsByName(String name) {
		String productName = "%" + name.toUpperCase() + "%";
		return ir.getItemsByName(productName);
	}

	public List<Item> getItemsByPriceRange(double low, double high) {
		return ir.getItemsInPriceRange(low, high);
	}

	public List<Item> getItemsByCategory(String category) {
		category = category.toUpperCase();
		return ir.getItemsByCategory(category);
	}

	public void addQuantity(int productId, int quantity) {
		Item item = ir.findById(productId).orElse(null);

		if (item != null) {
			item.setQuantity(item.getQuantity() + quantity);
			ir.save(item);
		}
	}

	public void changePrice(int productId, double price) {
		Item item = ir.findById(productId).orElse(null);

		if (item != null) {
			item.setPrice(price);
			ir.save(item);
		}
	}

	public void changeDescription(int productId, String description) {
		Item item = ir.findById(productId).orElse(null);

		if (item != null) {
			item.setDescription(description);
			ir.save(item);
		}
	}

	public void changeCategory(int productId, String category) {
		Item item = ir.findById(productId).orElse(null);

		if (item != null) {
			item.setCategory(category.toUpperCase());
			ir.save(item);
		}
	}
	
	public void addItemToCatalogue(HttpServletRequest request, Item i) {
		ir.save(i);
		
		String directoryPath = request.getServletContext().getRealPath("\\")+"\\image";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		//factory.setRepository(repository);
		List<FileItem> items;
		try {
			items = upload.parseRequest(request);
			Iterator<FileItem> fieldsIterator = items.iterator();
			
			while(fieldsIterator.hasNext()) {
				FileItem item = fieldsIterator.next();
				if(!item.isFormField()) {
					File uploadedFile = new File(directoryPath+"\\"+getHighestProductID()+".JPG");
					item.write(uploadedFile);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
