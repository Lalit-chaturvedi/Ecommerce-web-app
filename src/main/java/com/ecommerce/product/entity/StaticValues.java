package com.ecommerce.product.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Hitesh
 */
@Entity
@Table(name = "static_values")
@Data
public class StaticValues {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "static_values_id")
    private int id;
    private String name;
    private String value;
    private boolean active = false;



}
