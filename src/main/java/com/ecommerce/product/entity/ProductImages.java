package com.ecommerce.product.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * @author Hitesh
 */
@Entity
@Table(name = "product_images")
@Data
public class ProductImages {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "product_images_id")
    private Long id;

    private String imageUrl;
    private String imageName;
    private String imageType;
    private long imageSize;
    private String imagePath;
    private String imageDescription;
    private boolean active = false;
    private boolean defaultImage = false;
}
