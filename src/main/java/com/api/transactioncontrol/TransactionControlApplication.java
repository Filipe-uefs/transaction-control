package com.api.transactioncontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TransactionControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionControlApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Ola mundo";
	}
}
