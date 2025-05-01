package com.ecommerce.product.entity;

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
    @Column(name = "productcategory_id")
    private Long id;
    private String name;
    private boolean active = false;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "productcategory_id", name = "fk_productcategory_id")
    private List<ProductSubCategory> productSubCategoryList = new ArrayList<>();


}
