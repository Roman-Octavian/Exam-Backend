package com.exambackend.order;

import com.exambackend.delivery.Delivery;
import com.exambackend.product.Product;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name= "product_id")
    private Product product;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name= "delivery_id")
    private Delivery delivery;

    // Constructors
    public Order() {
    }

    public Order(Integer quantity, Product product, Delivery delivery) {
        this.quantity = quantity;
        this.product = product;
        this.delivery = delivery;
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

    public Delivery getDelivery() {
        return delivery;
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

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
