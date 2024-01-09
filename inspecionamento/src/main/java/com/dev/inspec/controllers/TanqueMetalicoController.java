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

import com.dev.inspec.entities.TanqueMetalico;
import com.dev.inspec.repositories.TanqueMetalicoRepository;

@RestController
@RequestMapping(value = "/tanque_metalico")
public class TanqueMetalicoController {

	@Autowired
	private TanqueMetalicoRepository repository;

	@GetMapping
	public List<TanqueMetalico> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TanqueMetalico> findById(@PathVariable Long id) {
		Optional<TanqueMetalico> tanqueMetalicoOptional = repository.findById(id);
		return tanqueMetalicoOptional.map(tanqueMetalico -> ResponseEntity.ok().body(tanqueMetalico))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public TanqueMetalico insert(@RequestBody TanqueMetalico tanqueMetalico) {
		return repository.save(tanqueMetalico);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TanqueMetalico> update(@PathVariable Long id, @RequestBody TanqueMetalico tanqueMetalicoAtualizado) {
		Optional<TanqueMetalico> existingTanqueMetalicoOptional = repository.findById(id);

		return existingTanqueMetalicoOptional.map(existingTanqueMetalico -> {
			existingTanqueMetalico.setDados_soldagem(tanqueMetalicoAtualizado.getDados_soldagem());
			existingTanqueMetalico.setDados_localizacao_identificacao(tanqueMetalicoAtualizado.getDados_localizacao_identificacao());
			existingTanqueMetalico.setDocumentacao_projeto(tanqueMetalicoAtualizado.getDocumentacao_projeto());
			existingTanqueMetalico.setDocumentacao_regulatoria(tanqueMetalicoAtualizado.getDocumentacao_regulatoria());
			existingTanqueMetalico.setHistorico_manutencao(tanqueMetalicoAtualizado.getHistorico_manutencao());
			existingTanqueMetalico.setInformacoes_operacao(tanqueMetalicoAtualizado.getInformacoes_operacao());
			existingTanqueMetalico.setInspecao_visual(tanqueMetalicoAtualizado.getInspecao_visual());
			existingTanqueMetalico.setMonitoramento_corrosao(tanqueMetalicoAtualizado.getMonitoramento_corrosao());
			existingTanqueMetalico.setProtecao_contra_corrosao(tanqueMetalicoAtualizado.getProtecao_contra_corrosao());
			existingTanqueMetalico.setRegistros_juntas(tanqueMetalicoAtualizado.getRegistros_juntas());
			existingTanqueMetalico.setRegistros_certificacao_pessoal(tanqueMetalicoAtualizado.getRegistros_certificacao_pessoal());
			existingTanqueMetalico.setTestes_hidrostaticos(tanqueMetalicoAtualizado.getTestes_hidrostaticos());
			existingTanqueMetalico.setTestes_nao_destrutivos(tanqueMetalicoAtualizado.getTestes_nao_destrutivos());
			existingTanqueMetalico.setEquipamento(tanqueMetalicoAtualizado.getEquipamento());
			TanqueMetalico updatedTanqueMetalico = repository.save(existingTanqueMetalico);
			return ResponseEntity.ok().body(updatedTanqueMetalico);

		}).orElse(ResponseEntity.notFound().build());
	}

	  @DeleteMapping(value = "/{id}")
	    public ResponseEntity<String> delete(@PathVariable Long id) {
	        try {
	            Optional<TanqueMetalico> tanqueMetalicoOptional = repository.findById(id);

	            if (tanqueMetalicoOptional.isPresent()) {
	            	TanqueMetalico tanqueMetalico = tanqueMetalicoOptional.get();
	                repository.deleteById(id);
	                return ResponseEntity.ok("Tanque Metalico com ID " + id + " (" + tanqueMetalico.getDados_soldagem() + ") foi deletado com sucesso.");
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Erro ao deletar Tanque Metalico com ID " + id + ": " + e.getMessage());
	        }
	    }
	}