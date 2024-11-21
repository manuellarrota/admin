package org.example.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EntityScan(basePackages={"org.example.core.domain"})
@ComponentScan(basePackages={"org.example.service", "org.example.connectors", "org.example.app.controllers"})
@EnableJpaRepositories( basePackages = {"org.example.core.repository"})
@Slf4j
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AppApplication.class);
		ConfigurableApplicationContext appConfig = app.run(args);
		Environment env = appConfig.getEnvironment();
		try {

			log.info("\n---------------------------------------------------------------\n\t" +
							" Swagger 2 : \t\thttp://{}:{}/swagger-ui/index.html\n\t" +
							"\n---------------------------------------------------------------",
					InetAddress.getLocalHost().getHostAddress(),
					env.getProperty("server.port"));
			log.info("\n---------------------------------------------------------------\n\t" +
							" Swagger 2 : \t\thttps://{}:{}/swagger-ui/index.html\n\t" +
							"\n---------------------------------------------------------------",
					InetAddress.getLocalHost().getHostAddress(),
					"8443");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
