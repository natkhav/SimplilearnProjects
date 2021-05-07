package com.app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//https://www.baeldung.com/jpa-many-to-many#many-to-many-using-a-composite-key
@Embeddable
public class ProductPurchaseKey implements Serializable {
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "purchase_id")
    private Long purchaseId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPurchaseKey that = (ProductPurchaseKey) o;
        return Objects.equals(productId, that.productId) && Objects.equals(purchaseId, that.purchaseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, purchaseId);
    }
}
