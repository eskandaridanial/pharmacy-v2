package com.pharmacy;

import com.pharmacy.conversion.Conversion;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PharmacyManagementSystemApplication {

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

	@Bean
	public Conversion getConversion(){
		return new Conversion();
	}

	public static void main(String[] args) {
		SpringApplication.run(PharmacyManagementSystemApplication.class, args);
	}

}
