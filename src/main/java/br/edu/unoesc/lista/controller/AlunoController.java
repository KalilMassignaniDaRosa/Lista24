package br.edu.unoesc.lista.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import br.edu.unoesc.lista.model.Aluno;
import br.edu.unoesc.lista.repository.AlunoRepository;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
	@Autowired
	private AlunoRepository repositorio;
	
	@GetMapping("/filtro")
	List<Aluno> listarComFiltro(@RequestParam("filtro") String filtro) {
		return repositorio.findByNomeContainingIgnoreCase(filtro);
	}
	
	@GetMapping("/")
	public Iterable<Aluno> listarTudo() {
		return repositorio.findAll();
	}
	
	@GetMapping("/salario")
	List<Aluno> listarPorSalario(@RequestParam("salario") BigDecimal salario) {
		return repositorio.porSalario(salario);
	}
	
	@DeleteMapping("/deletar/{id}")
	void deletarAluno(@PathVariable Long id) {
		Optional<Aluno> p = repositorio.findById(id);
		if (!p.isEmpty()) {
			System.out.println("Deletando o aluno ...");
			repositorio.delete(p.get());
		} 
	}
	
	@PostMapping("/incluir")
	Aluno incluirAluno(@RequestBody Aluno aluno)  {
		
		System.out.println("Incluindo novo aluno ...");
		
		return repositorio.save(aluno);
	}
	
	@PutMapping("/alterar")
	Aluno alterarAluno(@RequestBody Aluno aluno)  {
		
		System.out.println("Incluindo novo aluno ...");
		
		return repositorio.save(aluno);
	}
	
}
