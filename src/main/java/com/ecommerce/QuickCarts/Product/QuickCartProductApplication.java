package com.ecommerce.QuickCarts.Product;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.ecommerce.QuickCarts.Product.FeignClient")

@SpringBootApplication
public class QuickCartProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickCartProductApplication.class, args);
	}
	
	
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}

}
