package com.ecommerce.product.repository;

import com.ecommerce.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hitesh
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
