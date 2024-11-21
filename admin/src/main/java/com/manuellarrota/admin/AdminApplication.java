package com.manuellarrota.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@SpringBootApplication
public class AdminApplication {

	public static void main(String[] args) throws UnknownHostException {


		SpringApplication app = new SpringApplication(AdminApplication.class);
		ConfigurableApplicationContext applicationContext = app.run(args);
		Environment env = applicationContext.getEnvironment();
		String ip = InetAddress.getLocalHost().getHostAddress();
		log.info(
				" Swagger 2 : \t\thttp://{}:{}/\n\t",
				ip,
				env.getProperty("server.port"));
	}

}
