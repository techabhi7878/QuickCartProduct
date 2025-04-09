package com.ecommerce.QuickCarts.Product.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.QuickCarts.Product.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findByName(String name);

}
