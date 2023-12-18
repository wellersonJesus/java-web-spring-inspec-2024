package com.dev.inspec.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dev.inspec.dto.CadastroDTO;
import com.dev.inspec.entities.Cadastro;
import com.dev.inspec.repositories.CadastroRepository;

@RestController
@RequestMapping(value = "/cadastros")
public class CadastroController {

	@Autowired
	private CadastroRepository repository;

	@GetMapping
	public List<CadastroDTO> findAll() {
		List<Cadastro> cadastros = repository.findAll();
		return cadastros.stream().map(this::toDTO).collect(Collectors.toList());
	}

	@GetMapping(value = "/{id}")
	public CadastroDTO findById(@PathVariable Long id) {
		Cadastro cadastro = repository.findById(id).orElse(null);
		if (cadastro != null) {
			return toDTO(cadastro);
		} else {
			return null;
		}
	}

	@PostMapping
	public CadastroDTO insert(@RequestBody Cadastro cadastro) {
		Cadastro savedCadastro = repository.save(cadastro);
		return toDTO(savedCadastro);
	}

	@PutMapping(value = "/{id}")
	public CadastroDTO update(@PathVariable Long id, @RequestBody Cadastro cadastroAtualizado) {
		Cadastro existingCadastro = repository.findById(id).orElse(null);

		if (existingCadastro != null) {
			existingCadastro.setContato(cadastroAtualizado.getContato());
			existingCadastro.setCpfoucnpj(cadastroAtualizado.getCpfoucnpj());
			existingCadastro.setEndereco(cadastroAtualizado.getEndereco());

			Cadastro updatedCadastro = repository.save(existingCadastro);

			return toDTO(updatedCadastro);
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

	private CadastroDTO toDTO(Cadastro cadastro) {
		return new CadastroDTO(cadastro.getId(), cadastro.getContato());
	}
}
