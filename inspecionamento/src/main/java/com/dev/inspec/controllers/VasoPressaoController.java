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

import com.dev.inspec.entities.VasoPressao;
import com.dev.inspec.repositories.VasoPressaoRepository;

@RestController
@RequestMapping(value = "/vaso_pressao")
public class VasoPressaoController {

    @Autowired
    private VasoPressaoRepository repository;

    @GetMapping
    public List<VasoPressao> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VasoPressao> findById(@PathVariable Long id) {
        Optional<VasoPressao> vasoPressaoOptional = repository.findById(id);
        return vasoPressaoOptional.map(vasoPressao -> ResponseEntity.ok().body(vasoPressao))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public VasoPressao insert(@RequestBody VasoPressao vasoPressao) {
        return repository.save(vasoPressao);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VasoPressao> update(@PathVariable Long id, @RequestBody VasoPressao vasoPressaoAtualizado) {
        Optional<VasoPressao> existingVasoPressaoOptional = repository.findById(id);

        return existingVasoPressaoOptional.map(existingVasoPressao -> {
            existingVasoPressao.setCategoria_id(vasoPressaoAtualizado.getCategoria_id());
            existingVasoPressao.setCodigo_projeto(vasoPressaoAtualizado.getCodigo_projeto());
            existingVasoPressao.setCodigo_vaso(vasoPressaoAtualizado.getCodigo_vaso());
            existingVasoPressao.setComprimento_costado(vasoPressaoAtualizado.getComprimento_costado());
            existingVasoPressao.setDiametro_interno(vasoPressaoAtualizado.getDiametro_interno());
            existingVasoPressao.setFabricante(vasoPressaoAtualizado.getFabricante());
            existingVasoPressao.setPressao_interna_projeto(vasoPressaoAtualizado.getPressao_interna_projeto());
            existingVasoPressao.setPressao_trabalho(vasoPressaoAtualizado.getPressao_trabalho());
            existingVasoPressao.setPressao_teste_hidrostatico(vasoPressaoAtualizado.getPressao_teste_hidrostatico());
            existingVasoPressao.setProprietario_vaso(vasoPressaoAtualizado.getProprietario_vaso());
            existingVasoPressao.setSerie(vasoPressaoAtualizado.getSerie());
            existingVasoPressao.setTemperatura_interna_projeto(vasoPressaoAtualizado.getTemperatura_interna_projeto());
            existingVasoPressao.setTipo_vaso(vasoPressaoAtualizado.getTipo_vaso());
            existingVasoPressao.setVaso_id_tag(vasoPressaoAtualizado.getVaso_id_tag());
            existingVasoPressao.setVolume(vasoPressaoAtualizado.getVolume());
            existingVasoPressao.setEquipamento(vasoPressaoAtualizado.getEquipamento());
            VasoPressao updatedVasoPressao = repository.save(existingVasoPressao);
            return ResponseEntity.ok().body(updatedVasoPressao);
        
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            Optional<VasoPressao> vasoPressaoOptional = repository.findById(id);

            if (vasoPressaoOptional.isPresent()) {
            	VasoPressao vasoPressao = vasoPressaoOptional.get();
                repository.deleteById(id);
                return ResponseEntity.ok("VasoPressao com ID " + id + " (" + vasoPressao.getCategoria_id() + ") foi deletado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar Vaso de pressao com ID " + id + ": " + e.getMessage());
        }
    }
}