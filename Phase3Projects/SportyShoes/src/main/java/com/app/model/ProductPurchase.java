package com.app.model;

import javax.persistence.*;

@Entity
public class ProductPurchase {
    @EmbeddedId
    private ProductPurchaseKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @MapsId("purchaseId")
    @JoinColumn(name = "purchaseId")
    private Purchase purchase;

    private Integer quantity;

    public ProductPurchaseKey getId() {
        return id;
    }

    public void setId(ProductPurchaseKey id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
