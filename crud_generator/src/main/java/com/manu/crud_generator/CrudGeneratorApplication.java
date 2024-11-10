package com.manu.crud_generator;

import lombok.extern.slf4j.Slf4j;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
public class CrudGeneratorApplication {

	public static void main(String[] args) throws MojoExecutionException, MojoFailureException {
		SpringApplication.run(CrudGeneratorApplication.class, args);
		GenerateMojo generateMojo = new GenerateMojo();
		generateMojo.execute();
	}

}
