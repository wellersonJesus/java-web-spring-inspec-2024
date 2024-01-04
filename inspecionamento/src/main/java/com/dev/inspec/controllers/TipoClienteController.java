package com.dev.inspec.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.inspec.entities.TipoCliente;
import com.dev.inspec.repositories.TipoClienteRepository;

@RestController
@RequestMapping(value = "/tipo_cliente")
public class TipoClienteController {

    @Autowired
    private TipoClienteRepository repository;

    @GetMapping
    public List<TipoCliente> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoCliente> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(tipoCliente -> ResponseEntity.ok().body(tipoCliente))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoCliente insert(@RequestBody TipoCliente tipoCliente) {
        return repository.save(tipoCliente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TipoCliente> update(@PathVariable Long id, @RequestBody TipoCliente tipoClienteAtualizado) {
        return repository.findById(id)
                .map(existingTipoCliente -> {
                    existingTipoCliente.setName(tipoClienteAtualizado.getName());
                    return ResponseEntity.ok().body(repository.save(existingTipoCliente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            Optional<TipoCliente> tipoClienteOptional = repository.findById(id);

            if (tipoClienteOptional.isPresent()) {
                TipoCliente tipoCliente = tipoClienteOptional.get();
                repository.deleteById(id);
                return ResponseEntity.ok("TipoCliente com ID " + id + " (" + tipoCliente.getName() + ") foi deletado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar TipoCliente com ID " + id + ": " + e.getMessage());
        }
    }

}