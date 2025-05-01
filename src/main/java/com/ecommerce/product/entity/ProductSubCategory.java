package com.ecommerce.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "productsubcategory_id")
    private Long id;
    private String name;
    private boolean active = false;

}
