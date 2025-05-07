package com.ecommerce.QuickCarts.Product.Service;

import java.util.List;

import com.ecommerce.QuickCarts.Product.DTO.ProductDto;

public interface ProductService {
	
	ProductDto createProduct(ProductDto productDto);
	ProductDto updateProduct(Long id, ProductDto productDto);
	void deleteProduct(Long id);
	ProductDto getProductById(Long id);
	
	List<ProductDto>getAllProducts();
	List<ProductDto> filterByBrand(String brand); 

}
