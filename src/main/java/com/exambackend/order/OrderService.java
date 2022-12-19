package com.exambackend.order;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(Order order) {
        Optional<Order> orderOptional = orderRepository.findById(order.getId());
        if (orderOptional.isPresent()) {
            throw new IllegalStateException("Order already exists.");
        }
        orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Transactional
    public void updateOrder(Long id, Order order) {
        Order storedOrder = orderRepository.findById(id).orElseThrow(
                () ->  new IllegalStateException("Order with ID " + id + " does not exist."));
        if (order.getProduct() != null) {
            storedOrder.setProduct(order.getProduct());
        }
        if (order.getQuantity() != null) {
            storedOrder.setQuantity(order.getQuantity());
        }
    }

    public void deleteOrder(Long id) {
        boolean exists = orderRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Order with ID " + id + " does not exist.");
        }
        orderRepository.deleteById(id);
    }
}
