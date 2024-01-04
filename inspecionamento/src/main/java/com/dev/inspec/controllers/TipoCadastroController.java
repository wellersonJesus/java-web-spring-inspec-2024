package com.dev.inspec.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.inspec.entities.TipoCadastro;
import com.dev.inspec.repositories.TipoCadastroRepository;

@RestController
@RequestMapping(value = "/tipo_cadastro")
public class TipoCadastroController {

    @Autowired
    private TipoCadastroRepository repository;

    @GetMapping
    public List<TipoCadastro> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoCadastro> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(tipoCadastro -> ResponseEntity.ok().body(tipoCadastro))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TipoCadastro insert(@RequestBody TipoCadastro tipoCadastro) {
        return repository.save(tipoCadastro);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TipoCadastro> update(@PathVariable Long id, @RequestBody TipoCadastro tipoCadastroAtualizado) {
        return repository.findById(id)
                .map(existingTipoCadastro -> {
                    existingTipoCadastro.setContato(tipoCadastroAtualizado.getContato());
                    return ResponseEntity.ok().body(repository.save(existingTipoCadastro));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            Optional<TipoCadastro> tipoCadastroOptional = repository.findById(id);

            if (tipoCadastroOptional.isPresent()) {
                TipoCadastro tipoCadastro = tipoCadastroOptional.get();
                repository.deleteById(id);
                return ResponseEntity.ok("TipoCadastro com ID " + id + " (" + tipoCadastro.getContato() + ") foi deletado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar TipoCadastro com ID " + id + ": " + e.getMessage());
        }
    }

}