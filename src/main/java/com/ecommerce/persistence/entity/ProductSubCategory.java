package com.ecommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Hitesh
 */
@Entity
@Table(name = "productsubcategory")
@Data
public class ProductSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "productCategory_id")
    private ProductCategory productCategory;

//    public ProductSubCategory(String name, String description, boolean active, ProductCategory productCategory) {
//        this.name = name;
//        this.description = description;
//        this.active = active;
//        this.productCategory = productCategory;
//    }
//
//    public ProductSubCategory() {
//    }
}
