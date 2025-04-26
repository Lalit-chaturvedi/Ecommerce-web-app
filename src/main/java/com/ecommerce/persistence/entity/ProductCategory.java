package com.ecommerce.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hitesh
 */
@Entity
@Table(name = "productcategory")
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean active;
    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductSubCategory> productSubCategoryList = new ArrayList<>();
//    public ProductCategory(String name, String description, boolean active) {
//        this.name = name;
//        this.description = description;
//        this.active = active;
//    }

}
