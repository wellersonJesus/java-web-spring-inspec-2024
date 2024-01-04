package com.dev.inspec.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.inspec.entities.Cliente;
import com.dev.inspec.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(cliente -> ResponseEntity.ok().body(cliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente insert(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        return repository.findById(id)
                .map(existingCliente -> {
                    existingCliente.setName(clienteAtualizado.getName());
                    existingCliente.setEmail(clienteAtualizado.getEmail());
                    existingCliente.setTipoCliente(clienteAtualizado.getTipoCliente());
                    return ResponseEntity.ok().body(repository.save(existingCliente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            Optional<Cliente> clienteOptional = repository.findById(id);

            if (clienteOptional.isPresent()) {
                Cliente cliente = clienteOptional.get();
                repository.deleteById(id);
                return ResponseEntity.ok("Cliente com ID " + id + " (" + cliente.getName() + ") foi deletado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar Cliente com ID " + id + ": " + e.getMessage());
        }
    }
}