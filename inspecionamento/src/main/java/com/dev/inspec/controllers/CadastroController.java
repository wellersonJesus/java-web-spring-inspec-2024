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
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroRepository repository;

    @GetMapping
    public ResponseEntity<List<Cadastro>> findAll() {
        List<Cadastro> cadastros = repository.findAll();
        return ResponseEntity.ok(cadastros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cadastro> findById(@PathVariable Long id) {
        Optional<Cadastro> cadastroOptional = repository.findById(id);
        return cadastroOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Cadastro cadastro) {
        try {
            validateCadastro(cadastro);
            Cadastro savedCadastro = repository.save(cadastro);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCadastro);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao inserir Cadastro: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Cadastro cadastroAtualizado) {
        try {
            validateCadastro(cadastroAtualizado);
            Optional<Cadastro> existingCadastroOptional = repository.findById(id);

            if (existingCadastroOptional.isPresent()) {
                Cadastro existingCadastro = existingCadastroOptional.get();
                existingCadastro.setContato(cadastroAtualizado.getContato());
                existingCadastro.setCpf_ou_cnpj(cadastroAtualizado.getCpf_ou_cnpj());
                existingCadastro.setEndereco(cadastroAtualizado.getEndereco());
                existingCadastro.setTipoCadastro(cadastroAtualizado.getTipoCadastro());

                return ResponseEntity.ok().body(repository.save(existingCadastro));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar Cadastro: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
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

    private void validateCadastro(Cadastro cadastro) {
        if (cadastro.getContato() == null || cadastro.getCpf_ou_cnpj() == null || cadastro.getEndereco() == null) {
            throw new IllegalArgumentException("Campos obrigatórios não podem ser nulos.");
        }

    }
}
