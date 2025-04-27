package com.ecommerce.persistence.repository;

import com.ecommerce.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hitesh
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
