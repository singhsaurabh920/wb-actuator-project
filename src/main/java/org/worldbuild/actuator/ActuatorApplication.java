package org.worldbuild.actuator;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
@Log4j2
@SpringBootApplication
public class ActuatorApplication implements CommandLineRunner {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(ActuatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("PUBLIC_IP - "+environment.getProperty("PUBLIC_IP"));
		log.info("PUBLIC_IP - "+System.getProperty("PUBLIC_IP"));
		log.info("PUBLIC_IP - "+System.getenv("PUBLIC_IP"));
		log.info("ENV - "+System.getenv());

	}
}
