package com.saeeds28.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saeeds28.config.model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{
	
	@Query("Select p.productID from Purchase_Order_List p GROUP BY p.productID having sum(p.quantity) > 0 order by p.productID")
	List<Integer> getTopPurchasedItemsProductID();
	
	@Query("SELECT Distinct i.category from Item_List i")
	List<String> getProductCategory();
	
	@Query("SELECT i FROM Item_List i WHERE i.price >= :low and i.price <= :high")
	List<Item> getItemsInPriceRange(double low, double high);
	
	@Query("SELECT i FROM Item_List i WHERE i.name like :productName")
	List<Item> getItemsByName(@Param("productName") String pName);
	
	@Query("SELECT i FROM Item_List i WHERE i.category like :cat")
	List<Item> getItemsByCategory(@Param("cat") String category);
	
	@Query("SELECT MAX(i.productID) FROM Item_List i")
	Integer getMaxPid();
}
