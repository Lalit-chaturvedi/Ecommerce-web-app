package com.ecommerce.persistence.repository;

import com.ecommerce.persistence.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * @author Hitesh
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    // Alternatively, using @Query annotation
    @Query("SELECT pc FROM ProductCategory pc WHERE pc.name = :name")
    Optional<ProductCategory> findByCategoryName(@Param("name") String name);
}
