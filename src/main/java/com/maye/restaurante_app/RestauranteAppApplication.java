package com.maye.restaurante_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class RestauranteAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestauranteAppApplication.class, args);
	}
}