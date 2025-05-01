package com.ecommerce.product.repository;

import com.ecommerce.product.entity.ProductSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hitesh
 */
public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Long> {
}
