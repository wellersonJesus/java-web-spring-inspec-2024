package com.dev.inspec.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import com.dev.inspec.dto.ClienteDTO;
import com.dev.inspec.dto.tipo_cadastroDTO;
import com.dev.inspec.entities.Cliente;
import com.dev.inspec.repositories.ClienteRepository;
import com.dev.inspec.repositories.TipoClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@SuppressWarnings("unused")
	@Autowired
	private TipoClienteRepository tipoClienteRepository;

	@GetMapping
	public List<ClienteDTO> findAll() {
		List<Cliente> clientes = clienteRepository.findAll();
		return clientes.stream().map(this::toDTO).collect(Collectors.toList());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);

		if (cliente != null) {
			return ResponseEntity.ok(toDTO(cliente));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<ClienteDTO> insert(@RequestBody Cliente cliente) {
		Cliente savedCliente = clienteRepository.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(toDTO(savedCliente));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
		Cliente existingCliente = clienteRepository.findById(id).orElse(null);

		if (existingCliente != null) {
			existingCliente.setNome(clienteAtualizado.getNome());
			existingCliente.setEmail(clienteAtualizado.getEmail());
			existingCliente.setTipoCliente(clienteAtualizado.getTipoCliente());

			Cliente updatedCliente = clienteRepository.save(existingCliente);

			return ResponseEntity.ok(toDTO(updatedCliente));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok("Cliente com ID " + id + " foi excluído com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro ao excluir cliente com ID " + id + ": " + e.getMessage());
		}
	}

	private ClienteDTO toDTO(Cliente cliente) {
		tipo_cadastroDTO tipoClienteDTO = null;

		if (cliente.getTipoCliente() != null) {
			tipoClienteDTO = new tipo_cadastroDTO(cliente.getTipoCliente().getId(), cliente.getTipoCliente().getNome());
		}

		return new ClienteDTO(cliente.getId(), cliente.getNome(), tipoClienteDTO);
	}
}
