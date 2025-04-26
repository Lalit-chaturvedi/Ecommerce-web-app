package com.ecommerce.controller;

import com.ecommerce.persistence.entity.ProductSubCategory;
import com.ecommerce.service.ProductSubCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-subcategories")
public class ProductSubCategoryController {
    private final ProductSubCategoryService productSubCategoryService;

    public ProductSubCategoryController(ProductSubCategoryService productSubCategoryService) {
        this.productSubCategoryService = productSubCategoryService;
    }

    @GetMapping
    public List<ProductSubCategory> getAllSubCategories() {
        return productSubCategoryService.getAllSubCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductSubCategory> getSubCategoryById(@PathVariable Long id) {
        return productSubCategoryService.getSubCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /*
     * {
     *   "name": "string",
     *   "description": "string",
     *   "active": true,
     *   "productCategory": {
     *     "id": 1,
     *     "name": "string",
     *     "description": "string",
     *     "active": true
     *   }
     * }
     */
    @PostMapping
    public ProductSubCategory createSubCategory(@RequestBody ProductSubCategory productSubCategory) {
        return productSubCategoryService.createSubCategory(productSubCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductSubCategory> updateSubCategory(@PathVariable Long id, @RequestBody ProductSubCategory updatedSubCategory) {
        try {
            return ResponseEntity.ok(productSubCategoryService.updateSubCategory(id, updatedSubCategory));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteSubCategory(@PathVariable Long id) {
//        productSubCategoryService.deleteSubCategory(id);
//        return ResponseEntity.noContent().build();
//    }
}