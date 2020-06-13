package com.saeeds28.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saeeds28.model.PurchaseOrder;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer>{

	@Query("SELECT p FROM Purchase_Order_List p WHERE p.emailAddress = :username")
	List<PurchaseOrder> getPurchasesByUser(String username);

	@Query("SELECT SUM(p.quantity * p.price) from Purchase_Order_List p")
	Double getSumOfAllPurchases();
	
	@Query("SELECT SUM(p.quantity * p.price) from Purchase_Order_List p WHERE p.emailAddress = :name")
	Double getSumOfAllPurchases(@Param("name") String username);
	
	@Query("SELECT COUNT(p.productID) from Purchase_Order_List p where p.productID = :pid and p.emailAddress = :name")
	Integer getPurchaseCountForUser(@Param("pid") int productID, @Param("name") String username);
}
