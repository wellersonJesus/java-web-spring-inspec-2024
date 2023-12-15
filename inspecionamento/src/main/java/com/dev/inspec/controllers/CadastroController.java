package com.dev.inspec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.inspec.entities.Cadastro;
import com.dev.inspec.repositories.CadastroRepository;

@RestController
@RequestMapping(value = "/cadastros")
public class CadastroController {

	@Autowired
	private CadastroRepository repository;
	
	@GetMapping
	public List<Cadastro> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Cadastro findAll(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping
	public Cadastro insert(@RequestBody Cadastro cadastro) {
		return repository.save(cadastro);
	}
}
