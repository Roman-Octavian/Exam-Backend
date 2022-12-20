package com.exambackend.delivery;

import com.exambackend.order.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "deliveries")
public class Delivery {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", columnDefinition = "DATE NOT NULL")
    private LocalDate date;

    @Column(name = "warehouse", columnDefinition = "VARCHAR(30)")
    private String warehouse;

    @Column(name = "destination", columnDefinition = "VARCHAR(50)")
    private String destination;

    @OneToMany(mappedBy = "delivery")
    @JsonBackReference
    private List<Order> orders;

    // Constructors
    public Delivery() {
    }

    public Delivery(LocalDate date, String warehouse, String destination) {
        this.date = date;
        this.warehouse = warehouse;
        this.destination = destination;
    }

    public Delivery(LocalDate date, String warehouse, String destination, List<Order> orders) {
        this.date = date;
        this.warehouse = warehouse;
        this.destination = destination;
        this.orders = orders;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public String getDestination() {
        return destination;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
