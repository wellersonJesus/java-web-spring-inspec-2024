package com.dev.inspec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.inspec.entities.TipoCadastro;
import com.dev.inspec.repositories.TipoCadastroRepository;

@RestController
@RequestMapping(value = "/tipos_cadastro")
public class TipoCadastroController {

	@Autowired
	private TipoCadastroRepository repository;
	
	@GetMapping
	public List<TipoCadastro> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/{id}")
	public TipoCadastro findAll(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping
	public TipoCadastro insert(@RequestBody TipoCadastro tipocadastro) {
		return repository.save(tipocadastro);
	}
}
