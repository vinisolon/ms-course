package com.vinisolon.hrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

//	@Value("${spring.cloud.config.server.git.username}")
//	private String gitUsername;
//	@Value("${spring.cloud.config.server.git.passphrase}")
//	private String gitPassword;
//	@Value("${spring.cloud.config.server.git.private-key}")
//	private String privateKey;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("GIT USERNAME: " + gitUsername);
//		System.out.println("GIT PASSPHRASE: " + gitPassword);
//		System.out.println("PRIVATE-KEY: " + privateKey);
	}
}
