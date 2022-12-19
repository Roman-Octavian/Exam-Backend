package com.exambackend.product;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "VARCHAR(30) NOT NULL")
    private String name;

    @Column(name = "price", columnDefinition = "DECIMAL(15,2)")
    private Double price;

    @Column(name = "weight", columnDefinition = "INT")
    private Integer weight; // In grams

    // Constructors
    public Product() {
    }

    public Product(String name, Double price, Integer weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
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
}
