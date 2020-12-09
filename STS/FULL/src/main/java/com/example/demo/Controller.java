package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
@RequestMapping("/pagina")
public class Controller implements WebMvcConfigurer {

	// quando o usuario digitar localhost:8080 o sistema le como localhost:8080/

	public void addViewControllers(ViewControllerRegistry index) {
		index.addViewController("/").setViewName("forward:/index.html");
	}

	@Autowired
	private ManutencaoRepository repository;

	// posts inserir
	@PostMapping("/post1")
	public ManutencaoTable criar(@RequestBody ManutencaoTable objetinho) {
		repository.save(objetinho);
		return objetinho;
	}

	@PostMapping("/post2")
	public ResponseEntity<ManutencaoTable> post(@RequestBody ManutencaoTable objeto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(objeto));

	}

	// getAll select *
	// from------------------------------------------------------------------------------------------
	@GetMapping("/getAll1")
	public List<ManutencaoTable> pesquisarTodos() {
		return repository.findAll();
	}

	@GetMapping("/getAll2")
	public ResponseEntity<List<ManutencaoTable>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	// LOCALHOST:8080/pagina/getById1/1
	// gets by id select where
	// id-----------------------------------------------------------------------------------
	@GetMapping("/getById1/{id}")
	public Optional<ManutencaoTable> encontrarUm(@PathVariable Long id) {
		return repository.findById(id);

	}

	// LOCALHOST:8080/pagina/getById2/1
	@GetMapping("/getById2/{id}")
	public ResponseEntity<ManutencaoTable> GetById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	// Updates
	@PutMapping("/put1/{id}")
	public ManutencaoTable atualizar(@PathVariable long id, @RequestBody ManutencaoTable objetinho) {
		objetinho.setId(id);
		repository.save(objetinho);
		return objetinho;
	}

	@PutMapping("/put2")
	public ResponseEntity<ManutencaoTable> put(@RequestBody ManutencaoTable postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}

	// gets by id select where id
	@GetMapping("/getId1/{id}")
	public Optional<ManutencaoTable> encontrarUm(@PathVariable long id) {
		return repository.findById(id);
	}

	@GetMapping("/getId2/{id}")
	public ResponseEntity<ManutencaoTable> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());

	}

	// deletes------------------------------------------------------------------------------------
	@DeleteMapping("/delete/{id}")
	public String remover(@PathVariable Long id) {
		try {
			repository.deleteById(id);
			return "sucesso";
		} catch (Exception e) {
			return "Erro: " + e.getMessage();
		}
	}

}