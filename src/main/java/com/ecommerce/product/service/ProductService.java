package com.ecommerce.product.service;

import com.ecommerce.product.entity.Product;
import com.ecommerce.product.entity.ProductImages;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Hitesh
 */
@Service
public class ProductService {

    private final ProductRepository  productRepository;

    private static final String UPLOAD_DIR = "D:\\Downloads\\"; // Configure your upload directory

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product Product) {
        return productRepository.save(Product);
    }
    public Product createProduct(Product Product) {
        return productRepository.save(Product);
    }

    public Product updateProduct(Long id, Product product) {
        return productRepository.findById(id).map(productObj -> {
            productObj.setName(product.getName());
            productObj.setDescription(product.getDescription());
            productObj.setActive(product.isActive());
            productObj.setColor(product.getColor());
            productObj.setPrice(product.getPrice());
            productObj.setProductCategory(product.getProductCategory());
            productObj.setProductChangesQuestionsList(product.getProductChangesQuestionsList());
            return productRepository.save(productObj);
        }).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }



    private String generateUniqueFileName(String fileName) {
        return UUID.randomUUID().toString() + "_" + fileName;
    }
    public ResponseEntity<String> updateProductImages(Long id, MultipartFile file) {

        try {
            // 1. Validate file
            if (file.isEmpty()) {
                return new ResponseEntity<>("Please select a file to upload.", HttpStatus.BAD_REQUEST);
            }

            // 2. Sanitize file name
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // 3. Create a unique file name to avoid conflicts
            String uniqueFileName = generateUniqueFileName(fileName);

            // 4. Save the file to the server
            java.nio.file.Path filePath = Paths.get(UPLOAD_DIR, uniqueFileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            // 5. Update product with image path (Implement your product service)
            updateProductImageInDatabase(id, uniqueFileName,UPLOAD_DIR, file.getSize(),file.getContentType());

            return new ResponseEntity<>("Image uploaded successfully: " + uniqueFileName, HttpStatus.OK);

        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    private void updateProductImageInDatabase(Long id,String imageName ,String imagePath,long imageSize,
                                              String imageType) {
        productRepository.findById(id).ifPresent(product -> {
            ProductImages productImages = new ProductImages();
            productImages.setImageName(imageName);
            productImages.setImagePath(imagePath);
            productImages.setImageSize(imageSize);
            productImages.setImageType(imageType);
            productImages.setImageUrl("http://localhost:8080/products/" + id + "/image");
            productImages.setActive(true);
            productImages.setImageDescription("Product image for Front image " + product.getName());
            productImages.setDefaultImage(true); // Set default image to true
            product.getProductImagesList().add(productImages);
            productRepository.save(product);
        });
    }
}
