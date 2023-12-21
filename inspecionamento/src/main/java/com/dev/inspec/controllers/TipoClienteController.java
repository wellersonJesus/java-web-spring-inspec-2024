package com.dev.inspec.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.dev.inspec.entities.Cliente;
import com.dev.inspec.entities.TipoCliente;
import com.dev.inspec.repositories.ClienteRepository;
import com.dev.inspec.repositories.TipoClienteRepository;

@RestController
@RequestMapping(value = "/tipos_clientes")
public class TipoClienteController {

	@Autowired
	private TipoClienteRepository repository;

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<TipoCliente> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/{id}")
	public TipoCliente findById(@PathVariable Long id) {
		return repository.findById(id).orElse(null);
	}

	@PostMapping
	public TipoCliente insert(@RequestBody TipoCliente tipoCliente) {
		return repository.save(tipoCliente);
	}

	@PutMapping(value = "/{id}")
	public TipoCliente update(@PathVariable Long id, @RequestBody TipoCliente tipoClienteAtualizado) {
		TipoCliente existingTipoCliente = repository.findById(id).orElse(null);

		if (existingTipoCliente != null) {
			existingTipoCliente.setName(tipoClienteAtualizado.getName());
			return repository.save(existingTipoCliente);
		} else {
			return null;
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			TipoCliente deletedTipoCliente = repository.findById(id).orElse(null);

			if (deletedTipoCliente != null) {
				List<Cliente> clientes = clienteRepository.findByTipoCliente(deletedTipoCliente);

				if (!clientes.isEmpty()) {
					return ResponseEntity.status(HttpStatus.CONFLICT)
							.body("Não é possível excluir o TipoCliente com ID " + id
									+ " porque há registros associados na tabela Cliente.");
				}

				repository.deleteById(id);

				return ResponseEntity.ok("TipoCliente com ID " + id + " foi deletado com sucesso.");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body("TipoCliente com ID " + id + " não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao deletar TipoCliente com ID " + id + ": " + e.getMessage());
		}
	}
}
