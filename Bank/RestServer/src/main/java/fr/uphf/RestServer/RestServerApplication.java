package fr.uphf.RestServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * RestServerApplication : Class du serveur Tomcat (Bank) 
 * utilisee pour lancer le serveur Spring Boot (Tomcat 9.0.45)
 * 
 * @author Quentin Colras
 */

@SpringBootApplication
public class RestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServerApplication.class, args);
	}

}