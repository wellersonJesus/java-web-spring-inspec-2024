package com.dev.inspec.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.inspec.entities.Cadastro;
import com.dev.inspec.repositories.CadastroRepository;

@RestController
@RequestMapping(value = "/cadastro")
public class CadastroController {

    @Autowired
    private CadastroRepository repository;

    @GetMapping
    public List<Cadastro> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cadastro> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(cadastro -> ResponseEntity.ok().body(cadastro))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cadastro insert(@RequestBody Cadastro cadastro) {
        return repository.save(cadastro);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Cadastro> update(@PathVariable Long id, @RequestBody Cadastro cadastroAtualizado) {
        return repository.findById(id)
                .map(existingCadastro -> {
                    existingCadastro.setContato(cadastroAtualizado.getContato());
                    existingCadastro.setCpf_cnpj(cadastroAtualizado.getCpf_cnpj());
                    existingCadastro.setEndereco(cadastroAtualizado.getEndereco());
                    existingCadastro.setTipoCadastro(cadastroAtualizado.getTipoCadastro());
                    return ResponseEntity.ok().body(repository.save(existingCadastro));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            Optional<Cadastro> cadastroOptional = repository.findById(id);

            if (cadastroOptional.isPresent()) {
                Cadastro cadastro = cadastroOptional.get();
                repository.deleteById(id);
                return ResponseEntity.ok("Cadastro com ID " + id + " (" + cadastro.getContato() + ") foi deletado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar Cadastro com ID " + id + ": " + e.getMessage());
        }
    }
}