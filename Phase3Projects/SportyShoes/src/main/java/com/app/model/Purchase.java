package com.app.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "purchase")
    private Set<ProductPurchase> productPurchases;
    @ManyToOne( targetEntity=User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDate date;
    private Double total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ProductPurchase> getProductPurchases() {
        return productPurchases;
    }

    public void setProductPurchases(Set<ProductPurchase> productPurchases) {
        this.productPurchases = productPurchases;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
