package com.loanscompany.lam.loanwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		JndiConnectionFactoryAutoConfiguration.class})
@ComponentScan(basePackages = {"com.loanscompany.lam","com.loanscompany.lam.service"})
@EnableJpaRepositories({"com.loanscompany.lam"})
@EntityScan({"com.loanscompany.lam.model"})
@SpringBootApplication
public class LoanWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanWebAppApplication.class, args);
	}

}
