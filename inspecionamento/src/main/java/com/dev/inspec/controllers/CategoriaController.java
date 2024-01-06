package com.dev.inspec.controllers;

import java.util.List;
import java.util.Optional;

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

import com.dev.inspec.entities.Categoria;
import com.dev.inspec.repositories.CategoriaRepository;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = repository.findById(id);
        return categoriaOptional.map(categoria -> ResponseEntity.ok().body(categoria))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria insert(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoriaAtualizado) {
        Optional<Categoria> existingCategoriaOptional = repository.findById(id);

        return existingCategoriaOptional.map(existingCategoria -> {            
        	existingCategoria.setCategoria(categoriaAtualizado.getCategoria());
            existingCategoria.setVaso_pressao(categoriaAtualizado.getVaso_pressao());
            Categoria updatedCategoria = repository.save(existingCategoria);
            return ResponseEntity.ok().body(updatedCategoria);         
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            Optional<Categoria> categoriaOptional = repository.findById(id);

            if (categoriaOptional.isPresent()) {
            	Categoria categoria = categoriaOptional.get();
                repository.deleteById(id);
                return ResponseEntity.ok("Categoria com ID " + id + " (" + categoria.getCategoria() + ") foi deletado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar Categoria com ID " + id + ": " + e.getMessage());
        }
    }
}