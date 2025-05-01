package com.ecommerce.product.controller;

import com.ecommerce.product.entity.ProductSubCategory;
import com.ecommerce.product.service.ProductSubCategoryService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> createSubCategory(@RequestBody ProductSubCategory productSubCategory) {
        if(productSubCategory == null) {
            return new ResponseEntity<>("ProductSub Category cannot be null", HttpStatus.BAD_REQUEST);
        }
        productSubCategoryService.createSubCategory(productSubCategory);
        return new ResponseEntity<>("Product Sub Category created successfully", HttpStatus.CREATED);
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