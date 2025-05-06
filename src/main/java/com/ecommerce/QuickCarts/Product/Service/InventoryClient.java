package com.ecommerce.QuickCarts.Product.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "QuickCartInventory")
public interface InventoryClient {
	
	@GetMapping("/inventory/{productId}")
    boolean checkStock(@PathVariable("productId") Long productId);

}
