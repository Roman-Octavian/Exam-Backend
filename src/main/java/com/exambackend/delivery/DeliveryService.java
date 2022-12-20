package com.exambackend.delivery;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getDeliveries() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }

    public void addDelivery(Delivery delivery) {
        deliveryRepository.save(delivery);
    }

    @Transactional
    public void updateDelivery(Long id, Delivery delivery) {
        Delivery storedDelivery = deliveryRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Delivery with ID " + id + " does not exist"));
        if (delivery.getDate() != null) {
            storedDelivery.setDate(delivery.getDate());
        }
        if (delivery.getDestination() != null
                && delivery.getDestination().length() > 0
                && !Objects.equals(delivery.getDestination(), storedDelivery.getDestination())) {
            storedDelivery.setDestination(delivery.getDestination());
        }
        if (delivery.getWarehouse() != null
                && delivery.getWarehouse().length() > 0
                && !Objects.equals(delivery.getWarehouse(), storedDelivery.getWarehouse())) {
            storedDelivery.setWarehouse(delivery.getWarehouse());
        }
    }

    public void deleteDelivery(Long id) {
        boolean exists = deliveryRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Delivery with ID " + id + " does not exist.");
        }
        deliveryRepository.deleteById(id);
    }
}
