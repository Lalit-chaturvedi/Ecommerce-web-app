package com.ecommerce.service;

import com.ecommerce.persistence.entity.Product;
import com.ecommerce.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Hitesh
 */
@Service
public class ProductService {

    private final ProductRepository  productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product Product) {
        return productRepository.save(Product);
    }
    public Product createProduct(Product Product) {
        return productRepository.save(Product);
    }

    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id).map(productObj -> {
            productObj.setName(product.getName());
            productObj.setDescription(product.getDescription());
            productObj.setActive(product.isActive());
            productObj.setColor(product.getColor());
            productObj.setPrice(product.getPrice());
            productObj.setProductCategory(product.getProductCategory());
            productObj.setProductChangesQuestionsList(product.getProductChangesQuestionsList());
            return productRepository.save(productObj);
        }).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
