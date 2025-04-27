package com.ecommerce.controller;

import com.ecommerce.persistence.entity.Product;
import com.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Hitesh
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllCategories() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getCategoryById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /*
    {
  "name": "string22",
  "description": "string",
  "price": 0.1,
  "active": true,
  "color": "string22",
  "productCategory": {
    "name": "string22",
    "description": "string",
    "active": true,
    "productSubCategoryList": [
      {
        "name": "string22",
        "description": "string",
        "active": true
      }
    ]
  },
  "productChangesQuestionsList": [
    {
      "question": "height",
      "answer": true,
      "active": true
    },
{
      "question": "color",
      "answer": false,
      "active": true
    }
  ]
}
     */
    @PostMapping
    public ResponseEntity<String > createProuct(@RequestBody Product product) {
        if(product == null) {
            return new ResponseEntity<>("Product cannot be null", HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(product);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

    /*
    {
  "name": "stringaaa-",
  "description": "string",
  "price": 0.1,
  "active": true,
  "color": "string",
  "productCategory": {
    "name": "stringaaa",
    "description": "string",
    "active": true,
    "productSubCategoryList": [
      {
        "name": "stringaaa",
        "description": "string",
        "active": true
      }
    ]
  },
  "productChangesQuestionsList": [
    {
      "question": "string",
      "answer": true,
      "active": true
    }
  ]
}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        try {
            return ResponseEntity.ok(productService.updateProduct(id, updatedProduct));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
