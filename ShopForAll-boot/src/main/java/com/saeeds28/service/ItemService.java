package com.saeeds28.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeeds28.model.Item;
import com.saeeds28.model.ShoppingCartItem;
import com.saeeds28.model.UserSession;
import com.saeeds28.repository.ItemRepo;

@Service
public class ItemService {

	private static Logger itemLog = LogManager.getLogger("item");

	@Autowired
	ItemRepo ir;
	@Autowired
	CartService cs;

	int getHighestProductID() {
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
			itemLog.info("(" + UserSession.getLoggedInUser().getUsername() + ") added " + quantity + " of " + "("
					+ item.getProductID() + "," + item.getName() + ")");
		}
	}

	public void changePrice(int productId, double price) {
		Item item = ir.findById(productId).orElse(null);

		if (item != null) {
			item.setPrice(price);
			ir.save(item);
		}

		List<ShoppingCartItem> sci = cs.getShoppingCartItems(productId);
		if (sci != null && sci.size() > 0) {
			for (int i = 0; i < sci.size(); i++) {
				sci.get(i).setPrice(price);
			}
			cs.update(sci);
		}
		itemLog.info("(" + UserSession.getLoggedInUser().getUsername() + ") changed price to $" + price + " of " + "("
				+ item.getProductID() + "," + item.getName() + ")");
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

	public int addItem(HttpServletRequest request) {
		String name = "", desc = "", cat = "";
		double price = 0;
		int quantity = 0;

		String directoryPath = request.getServletContext().getRealPath("\\") + "\\image";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> items;
		try {
			items = upload.parseRequest(request);

			Iterator<FileItem> fieldsIterator = items.iterator();

			while (fieldsIterator.hasNext()) {
				FileItem item = fieldsIterator.next();
				if (item.isFormField()) {
					if (item.getFieldName().equals("name")) {
						name = item.getString();
					} else if (item.getFieldName().equals("price")) {
						price = Double.parseDouble(item.getString());
					} else if (item.getFieldName().equals("quantity")) {
						quantity = Integer.parseInt(item.getString());
					} else if (item.getFieldName().equals("description")) {
						desc = item.getString();
					} else if (item.getFieldName().equals("category")) {
						cat = item.getString();
					}
				} else {
					Item newItem = new Item(name, cat, desc, quantity, price);
					System.out.println("hit");
					ir.save(newItem);
					File uploadedFile = new File(directoryPath + "\\" + getHighestProductID() + ".JPG");
					item.write(uploadedFile);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		itemLog.info("(" + UserSession.getLoggedInUser().getUsername() + ") added item: (" + getHighestProductID() + ","
				+ name + "," + cat + "," + desc + "," + quantity + ", $" + price + ")");
		return getHighestProductID();
	}
}
