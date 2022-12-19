package com.exambackend.order;

import com.exambackend.product.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "INT")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name= "product_id")
    private Product product;

    // Constructors
    public Order() {
    }

    public Order(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
