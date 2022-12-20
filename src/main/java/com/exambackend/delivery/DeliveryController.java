package com.exambackend.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path= "api/v1/deliveries")
@CrossOrigin
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping()
    public List<Delivery> getDeliveries() {
        return deliveryService.getDeliveries();
    }

    @PostMapping()
    public Optional<Delivery> addDelivery(@RequestBody Delivery delivery) {
        deliveryService.addDelivery(delivery);
        return deliveryService.getDeliveryById(delivery.getId());
    }

    @PutMapping(path = "{id}")
    public List<Delivery> updateDelivery(@PathVariable("id") Long id, @RequestBody Delivery delivery) {
        deliveryService.updateDelivery(id, delivery);
        return deliveryService.getDeliveries();
    }

    @DeleteMapping(path = "{id}")
    public void deleteDelivery(@PathVariable("id") Long id) {
        deliveryService.deleteDelivery(id);
    }
}
