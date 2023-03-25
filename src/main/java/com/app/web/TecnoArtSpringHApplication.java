package com.app.web;




import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class TecnoArtSpringHApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(TecnoArtSpringHApplication.class, args);
		String password = "1234";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println(hashedPassword);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * PQRS pqrs1 = new PQRS( 3, 3, 2, "el producto llego en mal estado", new
		 * Date(), 10010); repositorio.save(pqrs1);
		 */


	}


	
	
	
	

}
