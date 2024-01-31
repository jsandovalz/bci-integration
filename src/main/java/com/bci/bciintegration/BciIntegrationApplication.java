package com.bci.bciintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(dateTimeProviderRef = "customDateTimeProvider")
public class BciIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BciIntegrationApplication.class, args);
	}

}
