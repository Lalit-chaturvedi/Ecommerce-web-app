package com.ecommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Hitesh
 */
@Entity
@Table(name = "product_changes_questions")
@Data
public class ProductChangesQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_chagques_id")
    private Long id;

    private String question;
    private boolean answer;
    private boolean active = false;

}
