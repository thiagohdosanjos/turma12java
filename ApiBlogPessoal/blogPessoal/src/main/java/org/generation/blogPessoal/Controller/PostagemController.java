package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	//End Point Get All
	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	//End Point Get by id
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id) {
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//End Point get by Title
	@GetMapping("/titulo/{title}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String title) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(title));
	}
	
	//Post
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem envio) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(envio));
	}
	
	//Put
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem edit) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(edit));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}