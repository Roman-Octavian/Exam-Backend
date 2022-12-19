package com.exambackend.product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    public void addProduct(Product product) {
        Optional<Product> productOptional = productRepository.findProductByName(product.getName());
        if (productOptional.isPresent()) {
            throw new IllegalStateException("Product already exists.");
        }
        productRepository.save(product);
    }

    @Transactional
    public void updateProduct(Long id, Product product) {
        Product storedProduct = productRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Product with ID " + id + " does not exist."));
        if (product.getName() != null) {
            storedProduct.setName(product.getName());
        }
        if (product.getPrice() != null) {
            storedProduct.setPrice(product.getPrice());
        }
        if (product.getWeight() != null) {
            storedProduct.setWeight(product.getWeight());
        }
    }

    public void deleteProduct(Long id) {
        boolean exists = productRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Product with ID " + id + " does not exist");
        }
        productRepository.deleteById(id);
    }
}
