//package br.edu.unoesc.lista.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.edu.unoesc.lista.model.Aluno;
//import br.edu.unoesc.lista.repository.LivroRepository;
//
//@RestController
//@RequestMapping("/api/livros")
//public class LivroController {
//	@Autowired
//	private LivroRepository repositorio;
//	
//	@GetMapping("/find")
//	List<Aluno> listarComFiltro(@RequestParam("filtro") String filtro) {
//		return repositorio.findByAutorContainingIgnoreCase(filtro);
//	}
//	
//	@GetMapping
//	public Iterable<Aluno> listarTudo() {
//		return repositorio.findAll();
//	}
//}
