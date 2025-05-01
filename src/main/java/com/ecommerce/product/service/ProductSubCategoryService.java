package com.ecommerce.product.service;

import com.ecommerce.product.entity.ProductSubCategory;
import com.ecommerce.product.repository.ProductSubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductSubCategoryService {
    private final ProductSubCategoryRepository productSubCategoryRepository;

    public ProductSubCategoryService(ProductSubCategoryRepository productSubCategoryRepository) {
        this.productSubCategoryRepository = productSubCategoryRepository;
    }

    public List<ProductSubCategory> getAllSubCategories() {
        return productSubCategoryRepository.findAll();
    }

    public Optional<ProductSubCategory> getSubCategoryById(Long id) {
        return productSubCategoryRepository.findById(id);
    }


    @Autowired
    ProductCategoryService productCategoryService;
    public ProductSubCategory createSubCategory(ProductSubCategory productSubCategory) {
        return productSubCategoryRepository.save(productSubCategory);
                //productCategoryService.getCategoryByName(productSubCategory.getProductCategory().getName()).get())); // Assuming you have a ProductCategory entity
    }

    public ProductSubCategory updateSubCategory(Long id, ProductSubCategory updatedSubCategory) {
        return productSubCategoryRepository.findById(id).map(subCategory -> {
            subCategory.setName(updatedSubCategory.getName());
            subCategory.setActive(updatedSubCategory.isActive());
            return productSubCategoryRepository.save(subCategory);
        }).orElseThrow(() -> new RuntimeException("SubCategory not found with id " + id));
    }

    public void deleteSubCategory(Long id) {
        productSubCategoryRepository.deleteById(id);
    }
}