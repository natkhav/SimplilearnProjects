package com.app.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    @OneToMany(mappedBy = "product")
    private Set<ProductPurchase> productPurchases;
    @ManyToOne( targetEntity=Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ProductPurchase> getProductPurchases() {
        return productPurchases;
    }

    public void setProductPurchases(Set<ProductPurchase> productPurchases) {
        this.productPurchases = productPurchases;
    }
}
