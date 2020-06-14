package com.saeeds28.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saeeds28.model.PurchaseOrder;

public interface CheckoutRepo extends JpaRepository<PurchaseOrder, Integer> {

}
