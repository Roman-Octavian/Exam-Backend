package com.exambackend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("name")
    public Optional<Product> getProductByName(@RequestParam String name) {
        return productService.getProductByName(name);
    }

    @PostMapping()
    public Optional<Product> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return productService.getProductByName(product.getName());
    }

    @PutMapping(path = "{id}")
    public List<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return productService.getProducts();
    }

    @DeleteMapping(path = "{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
