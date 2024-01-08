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

import com.dev.inspec.entities.Tubulacao;
import com.dev.inspec.repositories.TubulacaoRepository;

@RestController
@RequestMapping(value = "/tubulacao")
public class TubulacaoController {

    @Autowired
    private TubulacaoRepository repository;

    @GetMapping
    public List<Tubulacao> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tubulacao> findById(@PathVariable Long id) {
        Optional<Tubulacao> tubulacaoOptional = repository.findById(id);
        return tubulacaoOptional.map(tubulacao -> ResponseEntity.ok().body(tubulacao))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tubulacao insert(@RequestBody Tubulacao tubulacao) {
        return repository.save(tubulacao);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tubulacao> update(@PathVariable Long id, @RequestBody Tubulacao tubulacaoAtualizado) {
        Optional<Tubulacao> existingTubulacaoOptional = repository.findById(id);

        return existingTubulacaoOptional.map(existingTubulacao -> {
            existingTubulacao.setDados_localizacao_identificacao(Tubulacao.getDados_localizacao_identificacao());
            existingTubulacao.setDados_soldagem(tubulacaoAtualizado.getDados_soldagem());
            existingTubulacao.setDocumentacao_projeto(tubulacaoAtualizado.getDocumentacao_projeto());
            existingTubulacao.setDocumentacao_regulatoria(tubulacaoAtualizado.getDocumentacao_regulatoria());
            existingTubulacao.setHistorico_manutencao(tubulacaoAtualizado.getHistorico_manutencao());
            existingTubulacao.setInformacoes_operacao(tubulacaoAtualizado.getInformacoes_operacao());
            existingTubulacao.setInspecao_visual(tubulacaoAtualizado.getInspecao_visual());
            existingTubulacao.setMonitoramento_corrosao(tubulacaoAtualizado.getMonitoramento_corrosao());
            existingTubulacao.setRegistros_juntas(tubulacaoAtualizado.getRegistros_juntas());
            existingTubulacao.setRegistros_teste_pressao(tubulacaoAtualizado.getRegistros_teste_pressao());
            existingTubulacao.setRegistros_certificacao_pessoal(tubulacaoAtualizado.getRegistros_certificacao_pessoal());
            existingTubulacao.setTestes_nao_destrutivos(tubulacaoAtualizado.getTestes_nao_destrutivos());
            existingTubulacao.setTestes_hidrostaticos(tubulacaoAtualizado.getTestes_hidrostaticos());
            existingTubulacao.setEquipamento(tubulacaoAtualizado.getEquipamento());
            Tubulacao updatedTubulacao = repository.save(existingTubulacao);
            return ResponseEntity.ok().body(updatedTubulacao);
        
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            Optional<Tubulacao> tubulacaoOptional = repository.findById(id);

            if (tubulacaoOptional.isPresent()) {
				@SuppressWarnings("unused")
				Tubulacao tubulacao = tubulacaoOptional.get();
                repository.deleteById(id);
                return ResponseEntity.ok("Tubulacao com ID " + id + " (" + Tubulacao.getDados_localizacao_identificacao() + ") foi deletado com sucesso.");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar Caldera com ID " + id + ": " + e.getMessage());
        }
    }
}