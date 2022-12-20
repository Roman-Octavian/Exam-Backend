package com.exambackend.product;

import com.exambackend.order.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(30) NOT NULL")
    private String name;

    @Column(name = "price", columnDefinition = "DECIMAL(15,2) NOT NULL")
    private Double price;

    @Column(name = "weight", columnDefinition = "INT NOT NULL")
    private Integer weight; // In grams

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<Order> orders;

    // Constructors
    public Product() {
    }

    public Product(String name, Double price, Integer weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Product(String name, Double price, Integer weight, List<Order> orders) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.orders = orders;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getWeight() {
        return weight;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
