package com.ecommerce.controller;

import com.ecommerce.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Hitesh
 */
@RestController
@RequestMapping("/api/product/img")
public class ProductImageController {
    private ProductService productService;
    private final String imageDirectory = "D:\\Downloads\\"; // Configure your image directory

    public ProductImageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products/{productId}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getProductImage(@PathVariable String productId) throws IOException {
        // Validate the productId & TODO handle invalid productId and get product image path
        // Construct the image path
        Path imagePath = Paths.get(imageDirectory, productId + ".png"); // Assuming .png format

        // Read the image file into a byte array
        byte[] imageBytes = Files.readAllBytes(imagePath);

        // Return the image as a byte array with the correct content type
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }


    @PostMapping("/products/{id}/image")
    public ResponseEntity<String> uploadProductImage(@PathVariable Long id, @RequestParam("image") MultipartFile file) throws IOException {
        return productService.updateProductImages(id, file);
    }
}
