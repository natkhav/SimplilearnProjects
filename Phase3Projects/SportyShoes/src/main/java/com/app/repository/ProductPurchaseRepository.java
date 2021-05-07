package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.ProductPurchase;
import com.app.model.ProductPurchaseKey;

@Repository
public interface ProductPurchaseRepository extends JpaRepository<ProductPurchase, ProductPurchaseKey> {
}
