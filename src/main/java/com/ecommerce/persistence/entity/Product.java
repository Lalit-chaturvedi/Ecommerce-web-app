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
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;
    private String description;
    private Double price;
    private boolean active;
    private String color;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_productcategory_id")
    ProductCategory productCategory;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "product_id", name = "fk_product_id")
    List<ProductChangesQuestions> productChangesQuestionsList = new ArrayList<>();
}
