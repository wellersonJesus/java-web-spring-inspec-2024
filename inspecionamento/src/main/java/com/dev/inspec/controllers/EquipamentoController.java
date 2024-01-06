package com.dev.inspec.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.inspec.entities.Equipamento;
import com.dev.inspec.repositories.EquipamentoRepository;

@RestController
@RequestMapping(value = "/equipamento")
public class EquipamentoController {

    @Autowired
    private EquipamentoRepository repository;

    @GetMapping
    public List<Equipamento> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Equipamento> findById(@PathVariable Long id) {
        Optional<Equipamento> equipamentoOptional = repository.findById(id);
        return equipamentoOptional.map(equipamento -> ResponseEntity.ok().body(equipamento))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Equipamento insert(@RequestBody Equipamento equipamento) {
        return repository.save(equipamento);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Equipamento> update(@PathVariable Long id, @RequestBody Equipamento equipamentoAtualizado) {
        Optional<Equipamento> existingEquipamentoOptional = repository.findById(id);

        return existingEquipamentoOptional.map(existingEquipamento -> {
            existingEquipamento.setCaldera(equipamentoAtualizado.getCaldera());
            existingEquipamento.setVaso_de_pressao(equipamentoAtualizado.getVaso_de_pressao());
            existingEquipamento.setTubulacao(equipamentoAtualizado.getTubulacao());
            existingEquipamento.setTanque_metalico(equipamentoAtualizado.getTanque_metalico());
            existingEquipamento.setInspecao(equipamentoAtualizado.getInspecao());
            Equipamento updatedEquipamento = repository.save(existingEquipamento);
            return ResponseEntity.ok().body(updatedEquipamento);
        
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            Optional<Equipamento> equipamentoOptional = repository.findById(id);

            if (equipamentoOptional.isPresent()) {
            	Equipamento equipamento = equipamentoOptional.get();
                repository.deleteById(id);
                return ResponseEntity.ok("Equipamento com ID " + id + " (" + equipamento.getCaldera() + ") foi deletado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar Equipamento com ID " + id + ": " + e.getMessage());
        }
    }
}
