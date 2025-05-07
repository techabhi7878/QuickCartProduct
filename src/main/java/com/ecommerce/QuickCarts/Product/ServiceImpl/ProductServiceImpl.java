package com.ecommerce.QuickCarts.Product.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.QuickCarts.Product.DTO.ProductDto;
import com.ecommerce.QuickCarts.Product.Entity.Product;
import com.ecommerce.QuickCarts.Product.Repository.ProductRepository;
import com.ecommerce.QuickCarts.Product.Service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	 private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	    @Autowired
	    private ProductRepository productRepository;

	    @Autowired
	    private ModelMapper modelMapper;

	    @Override
	    public ProductDto createProduct(ProductDto productDto) {
	        logger.info("Creating product: {}", productDto.getName());
	        Product product = this.modelMapper.map(productDto, Product.class);
	        Product savedProduct = this.productRepository.save(product);
	        return modelMapper.map(savedProduct, ProductDto.class);
	    }

	    @Override
	    public ProductDto updateProduct(Long id, ProductDto productDto) {
	        logger.info("Updating product with ID: {}", id);
	        Product product = productRepository.findById(id)
	                .orElseThrow(() -> {
	                    logger.error("Product with ID {} not found", id);
	                    return new RuntimeException("Product not found");
	                });

	        product.setName(productDto.getName());
	        product.setDescription(productDto.getDescription());
	        product.setPrice(productDto.getPrice());
	        product.setStock(productDto.getStock());

	        Product updatedProduct = productRepository.save(product);
	        logger.info("Product with ID {} updated successfully", id);
	        return modelMapper.map(updatedProduct, ProductDto.class);
	    }

	    @Override
	    public void deleteProduct(Long id) {
	        logger.info("Deleting product with ID: {}", id);
	        Product product = productRepository.findById(id)
	                .orElseThrow(() -> {
	                    logger.error("Product with ID {} not found", id);
	                    return new RuntimeException("Product not found");
	                });

	        productRepository.delete(product);
	        logger.info("Product with ID {} deleted successfully", id);
	    }

	    @Override
	    public ProductDto getProductById(Long productId) {
	        logger.info("Fetching product with ID: {}", productId);
	        Product product = productRepository.findById(productId)
	                .orElseThrow(() -> {
	                    logger.error("Product with ID {} not found", productId);
	                    return new RuntimeException("Product not found");
	                });

	        return modelMapper.map(product, ProductDto.class);
	    }

	    @Override
	    public List<ProductDto> getAllProducts() {
	        logger.info("Fetching all products");
	        List<Product> products = productRepository.findAll();
	        return products.stream()
	                .map(product -> modelMapper.map(product, ProductDto.class))
	                .collect(Collectors.toList());
	    }

		@Override
		public List<ProductDto> filterByBrand(String brand) {
			List<Product> products = productRepository.findByBrandIgnoreCase(brand);
			return products.stream()
            .map(product -> modelMapper.map(product, ProductDto.class))
            .collect(Collectors.toList());
		}
	}


