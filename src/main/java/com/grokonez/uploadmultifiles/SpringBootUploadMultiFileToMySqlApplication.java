package com.grokonez.uploadmultifiles;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackageClasses = { 
		SpringBootUploadMultiFileToMySqlApplication.class,
		Jsr310JpaConverters.class 
})
@EnableTransactionManagement
public class SpringBootUploadMultiFileToMySqlApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootUploadMultiFileToMySqlApplication.class, args);
	}
}
