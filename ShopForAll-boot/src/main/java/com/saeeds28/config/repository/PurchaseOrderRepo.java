package com.saeeds28.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saeeds28.config.model.PurchaseOrder;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, Integer> {

}
