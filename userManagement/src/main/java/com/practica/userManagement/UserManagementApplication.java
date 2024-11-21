package com.practica.userManagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class UserManagementApplication {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(UserManagementApplication.class);
		ConfigurableApplicationContext applicationContext = app.run(args);
		Environment env = applicationContext.getEnvironment();
		String ip = InetAddress.getLocalHost().getHostAddress();
		log.info(
				" Swagger 2 : \t\thttp://{}:{}/swagger-ui/index.html\n\t",
				ip,
				env.getProperty("server.port"));
	}

}
