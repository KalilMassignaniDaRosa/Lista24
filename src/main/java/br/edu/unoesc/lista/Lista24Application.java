package br.edu.unoesc.lista;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.unoesc.lista.model.Aluno;
import br.edu.unoesc.lista.repository.AlunoRepository;

@SpringBootApplication
public class Lista24Application {

	public static void main(String[] args) {
		SpringApplication.run(Lista24Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AlunoRepository repositorio) {
		return args -> {
			Aluno a = new Aluno(null, "Fulano", new BigDecimal(2500.00),new Date());
			a = repositorio.save(a);
			System.out.println(a);

			//Adicionar novo
			repositorio.save(new Aluno(null, "Ademar", new BigDecimal(4000),new Date()));

			Optional<Aluno> p = repositorio.findById(1l);
			if (p.isEmpty()) {
				System.out.println("Registro não encontrado!");
			} else {
				System.out.println(p.get());
			}

			
			System.out.println(repositorio.findAll());

			//Alterar
			Aluno alterado = repositorio.findById((long) 3).get();
			alterado.setNome("Novo nome");
			alterado.setNascimento(new Date());;
			alterado.setSalario(new BigDecimal(1000));;
			repositorio.save(alterado);
			
			//Deletar
			//repositorio.deleteById((long) 2);

		};
	}
}
