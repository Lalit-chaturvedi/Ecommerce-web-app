package com.ecommerce.controller;

import com.ecommerce.persistence.entity.ProductCategory;
import com.ecommerce.service.ProductCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
 * @author Hitesh
 */
@RestController
@RequestMapping("/api/product-categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public List<ProductCategory> getAllCategories() {
        return productCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getCategoryById(@PathVariable Long id) {
        return productCategoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /*
     * {
     *   "name": "string",
     *   "description": "string",
     *   "active": true
     * }
     */
    @PostMapping
    public ProductCategory createCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.createCategory(productCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateCategory(@PathVariable Long id, @RequestBody ProductCategory updatedCategory) {
        try {
            return ResponseEntity.ok(productCategoryService.updateCategory(id, updatedCategory));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
//        productCategoryService.deleteCategory(id);
//        return ResponseEntity.noContent().build();
//    }
}