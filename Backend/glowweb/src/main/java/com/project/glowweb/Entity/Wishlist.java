package com.project.glowweb.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String productId;

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getProductId() {
        return productId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
