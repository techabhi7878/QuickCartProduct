package com.ecommerce.QuickCarts.Product.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Product_table")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	 private Long id;
	    
	@Column(nullable = false)
	    private String name;
	    private String description;
	    
	    
	    @Column(precision = 10, scale = 2)
	    private BigDecimal price;
	    
	    private int stock;
	
	
	

}
