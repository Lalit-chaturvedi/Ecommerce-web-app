package com.ecommerce.persistence.repository;

import com.ecommerce.persistence.entity.ProductSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hitesh
 */
public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Long> {
}
