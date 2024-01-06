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

import com.dev.inspec.entities.Caldera;
import com.dev.inspec.repositories.CalderaRepository;

@RestController
@RequestMapping(value = "/caldera")
public class CalderaController {

    @Autowired
    private CalderaRepository repository;

    @GetMapping
    public List<Caldera> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Caldera> findById(@PathVariable Long id) {
        Optional<Caldera> calderaOptional = repository.findById(id);
        return calderaOptional.map(caldera -> ResponseEntity.ok().body(caldera))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Caldera insert(@RequestBody Caldera caldera) {
        return repository.save(caldera);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Caldera> update(@PathVariable Long id, @RequestBody Caldera calderaAtualizado) {
        Optional<Caldera> existingCalderaOptional = repository.findById(id);

        return existingCalderaOptional.map(existingCaldera -> {
            existingCaldera.setAno_fabricao(calderaAtualizado.getAno_fabricao());
            existingCaldera.setCapacidade_producao_vapor_saturado(calderaAtualizado.getCapacidade_producao_vapor_saturado());
            existingCaldera.setCategoria(calderaAtualizado.getCategoria());
            existingCaldera.setCodigo_projeto_ano_edicao(calderaAtualizado.getCodigo_projeto_ano_edicao());
            existingCaldera.setCombustivel(calderaAtualizado.getCombustivel());
            existingCaldera.setMarca(calderaAtualizado.getMarca());
            existingCaldera.setModelo(calderaAtualizado.getModelo());
            existingCaldera.setNumero_ordem(calderaAtualizado.getNumero_ordem());
            existingCaldera.setPressao_teste_hidrostatico_fabricante(calderaAtualizado.getPressao_teste_hidrostatico_fabricante());
            existingCaldera.setPressao_efetiva_operacao(calderaAtualizado.getPressao_efetiva_operacao());
            existingCaldera.setSup_aquecimento(calderaAtualizado.getSup_aquecimento());
            existingCaldera.setAno_fabricao(calderaAtualizado.getAno_fabricao());
            existingCaldera.setEquipamento(calderaAtualizado.getEquipamento());
            Caldera updatedCaldera = repository.save(existingCaldera);
            return ResponseEntity.ok().body(updatedCaldera);
        
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            Optional<Caldera> calderaOptional = repository.findById(id);

            if (calderaOptional.isPresent()) {
            	Caldera caldera = calderaOptional.get();
                repository.deleteById(id);
                return ResponseEntity.ok("Caldera com ID " + id + " (" + caldera.getAno_fabricao() + ") foi deletado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar Caldera com ID " + id + ": " + e.getMessage());
        }
    }
}