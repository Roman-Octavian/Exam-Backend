package com.exambackend.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/orders")
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping(path = "{id}")
    public Optional<Order> getOrderById(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping()
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }

    @PutMapping(path = "{id}")
    public void updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        orderService.updateOrder(id, order);
    }

    @DeleteMapping(path = "{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }
}
