package com.dev.inspec.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.inspec.entities.Inspecao;
import com.dev.inspec.repositories.InspecaoRepository;

@RestController
@RequestMapping(value = "/inspecao")
public class InspecaoController {

    @Autowired
    private InspecaoRepository repository;

    @GetMapping
    public List<Inspecao> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Inspecao> findById(@PathVariable Long id) {
        Optional<Inspecao> inspecaoOptional = repository.findById(id);
        return inspecaoOptional.map(inspecao -> ResponseEntity.ok().body(inspecao))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inspecao insert(@RequestBody Inspecao inspecao) {
        return repository.save(inspecao);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Inspecao> update(@PathVariable Long id, @RequestBody Inspecao inspecaoAtualizado) {
        Optional<Inspecao> existingInspecaoOptional = repository.findById(id);

        return existingInspecaoOptional.map(existingInspecao -> {
            existingInspecao.setExtraordinaria(inspecaoAtualizado.getExtraordinaria());
            existingInspecao.setInicial(inspecaoAtualizado.getInicial());
            existingInspecao.setPeriodica_interna_externa(inspecaoAtualizado.getPeriodica_interna_externa());
            existingInspecao.setCliente(inspecaoAtualizado.getCliente());
            Inspecao updatedInspecao = repository.save(existingInspecao);
            return ResponseEntity.ok().body(updatedInspecao);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            Optional<Inspecao> inspecaoOptional = repository.findById(id);

            if (inspecaoOptional.isPresent()) {
                Inspecao inspecao = inspecaoOptional.get();
                repository.deleteById(id);
                return ResponseEntity.ok("Inspecao com ID " + id + " (" + inspecao.getExtraordinaria() + ") foi deletado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar Inspecao com ID " + id + ": " + e.getMessage());
        }
    }
}
