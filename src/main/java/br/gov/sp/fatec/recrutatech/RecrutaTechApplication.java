package br.gov.sp.fatec.recrutatech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RecrutaTechApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecrutaTechApplication.class, args);
	}

	@GetMapping(value = "/aluno")
	public Aluno getAluno(){
		Aluno aluno = new Aluno();
		aluno.nome = "fred";
		
		aluno.sobrenome = "rabelo2";
		return aluno;
	}


	class Aluno{
		public String nome;
		public String sobrenome;
	}
}
