
  package com.ecommerce.QuickCarts.Product.Service;
  
  import org.springframework.cloud.openfeign.FeignClient; import
  org.springframework.http.ResponseEntity; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable;
  
  import com.ecommerce.QuickCarts.Product.DTO.ProductDto;
  
  
 @FeignClient(name = "product-service", path = "/products") public interface
 ProductClient {

  @GetMapping("/{id}") ResponseEntity<ProductDto>
  getProductById(@PathVariable("id") Long id); }
 