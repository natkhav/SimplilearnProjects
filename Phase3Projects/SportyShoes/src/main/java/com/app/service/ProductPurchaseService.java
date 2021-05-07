package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.ProductPurchase;
import com.app.repository.ProductPurchaseRepository;

@Service
public class ProductPurchaseService {
    private ProductPurchaseRepository productPurchaseRepository;

    @Autowired
    public ProductPurchaseService(ProductPurchaseRepository productPurchaseRepository) {
        this.productPurchaseRepository = productPurchaseRepository;
    }

    public ProductPurchase save(ProductPurchase productPurchase) {
        return productPurchaseRepository.save(productPurchase);
    }
}
