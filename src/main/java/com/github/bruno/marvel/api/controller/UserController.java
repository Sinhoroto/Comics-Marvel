package com.github.bruno.marvel.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.bruno.marvel.domain.model.User;
import com.github.bruno.marvel.domain.repository.UserRepository;
import com.github.bruno.marvel.domain.service.CrudUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CrudUserService crudUserService;
	
	@GetMapping
	public List<User> listar() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<User> buscar(@PathVariable Long userid) {
		Optional<User> user = userRepository.findById(userid);
		
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User adicionar(@Valid @RequestBody User user) {
		return crudUserService.salvar(user);
	}
	
	@PutMapping("/{userid}")
	public ResponseEntity<User> atualizar(@Valid @PathVariable Long userid, @RequestBody User user){
		if(!userRepository.existsById(userid)) {
			return ResponseEntity.notFound().build();
		}
		
		user.setId(userid);
		user = crudUserService.salvar(user);
		
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{userid}")
	public ResponseEntity<Void> remover(@PathVariable Long userid) {
		if(!userRepository.existsById(userid)) {
			return ResponseEntity.notFound().build();
		}
		
		crudUserService.excluir(userid);
		
		return ResponseEntity.noContent().build();
	}
}
