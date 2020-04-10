package com.saeeds28.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saeeds28.config.model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{
	
	@Query("Select p.productID from Purchase_Order_List p GROUP BY p.productID having sum(p.quantity) > 0 order by p.productID")
	List<Integer> getTopPurchasedItemsProductID();
}
