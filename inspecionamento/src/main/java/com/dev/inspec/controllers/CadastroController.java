package com.dev.inspec.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private CadastroDTO toDTO(Cadastro cadastro) {
        return new CadastroDTO(cadastro.getId(), cadastro.getContato());
    }
}
