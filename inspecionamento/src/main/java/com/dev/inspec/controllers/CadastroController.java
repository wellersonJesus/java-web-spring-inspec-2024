package com.dev.inspec.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.inspec.dto.CadastroDTO;
import com.dev.inspec.dto.tipo_cadastroDTO;
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
    public ResponseEntity<CadastroDTO> findById(@PathVariable Long id) {
        Cadastro cadastro = repository.findById(id).orElse(null);

        if (cadastro != null) {
            return ResponseEntity.ok(toDTO(cadastro));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CadastroDTO> insert(@RequestBody Cadastro cadastro) {
        Cadastro savedCadastro = repository.save(cadastro);
        return ResponseEntity.status(HttpStatus.CREATED).body(toDTO(savedCadastro));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CadastroDTO> update(@PathVariable Long id, @RequestBody Cadastro cadastroAtualizado) {
        Cadastro existingCadastro = repository.findById(id).orElse(null);

        if (existingCadastro != null) {
            existingCadastro.setContato(cadastroAtualizado.getContato());
            existingCadastro.setCpfoucnpj(cadastroAtualizado.getCpfoucnpj());
            existingCadastro.setEndereco(cadastroAtualizado.getEndereco());

            Cadastro updatedCadastro = repository.save(existingCadastro);

            return ResponseEntity.ok(toDTO(updatedCadastro));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok("Cadastro com ID " + id + " foi excluído com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao excluir cadastro com ID " + id + ": " + e.getMessage());
        }
    }

    private CadastroDTO toDTO(Cadastro cadastro) {
        tipo_cadastroDTO tipoCadastroDTO = cadastro.getTipoCadastro() != null ?
                new tipo_cadastroDTO(cadastro.getTipoCadastro().getId(), cadastro.getTipoCadastro().getName()) : null;

        return new CadastroDTO(cadastro.getId(), cadastro.getContato(), tipoCadastroDTO);
    }
}
