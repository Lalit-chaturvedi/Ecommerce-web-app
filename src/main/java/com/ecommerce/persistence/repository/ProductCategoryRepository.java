package com.ecommerce.persistence.repository;

import com.ecommerce.persistence.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hitesh
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
