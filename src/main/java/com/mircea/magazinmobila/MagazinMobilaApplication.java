package com.mircea.magazinmobila;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.mircea.magazinmobila.service.StoreService;

@SpringBootApplication
public class MagazinMobilaApplication {

	@Autowired
	StoreService storeService;

	public static void main(String[] args) {
		SpringApplication.run(MagazinMobilaApplication.class, args);
	}

}
