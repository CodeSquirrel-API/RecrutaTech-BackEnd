package br.gov.sp.fatec.recrutatech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class RecrutaTechApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecrutaTechApplication.class, args);
	}

}
