package com.ecommerce.product.repository;

import com.ecommerce.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hitesh
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
