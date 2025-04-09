package com.ecommerce.QuickCarts.Product.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.QuickCarts.Product.DTO.ProductDto;
import com.ecommerce.QuickCarts.Product.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	 private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	    @Autowired
	    private ProductService productService;

	    @PostMapping
	    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
	        logger.info("Received request to create product: {}", productDto.getName());
	        return ResponseEntity.ok(productService.createProduct(productDto));
	    }

	    @PutMapping("/{productId}")
	    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long productId, @RequestBody ProductDto productDto) {
	        logger.info("Received request to update product with ID: {}", productId);
	        return ResponseEntity.ok(productService.updateProduct(productId, productDto));
	    }

	    @DeleteMapping("/{productId}")
	    public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
	        logger.info("Received request to delete product with ID: {}", productId);
	        productService.deleteProduct(productId);
	        return ResponseEntity.ok("Product deleted successfully");
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
	        logger.info("Received request to fetch product with ID: {}", id);
	        return ResponseEntity.ok(productService.getProductById(id));
	    }

	    @GetMapping
	    public ResponseEntity<List<ProductDto>> getAllProducts() {
	        logger.info("Received request to fetch all products");
	        return ResponseEntity.ok(productService.getAllProducts());
	    }
      
}


