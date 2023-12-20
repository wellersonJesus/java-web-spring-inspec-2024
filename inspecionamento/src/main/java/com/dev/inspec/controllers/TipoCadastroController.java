package com.dev.inspec.controllers;
import java.util.List;

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

import com.dev.inspec.entities.Cadastro;
import com.dev.inspec.entities.TipoCadastro;
import com.dev.inspec.repositories.CadastroRepository;
import com.dev.inspec.repositories.TipoCadastroRepository;

@RestController
@RequestMapping(value = "/tipos_cadastro")
public class TipoCadastroController {

    @Autowired
    private TipoCadastroRepository repository;

    @Autowired
    private CadastroRepository cadastroRepository; 

    @GetMapping
    public List<TipoCadastro> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public TipoCadastro findById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public TipoCadastro insert(@RequestBody TipoCadastro tipocadastro) {
        return repository.save(tipocadastro);
    }

    @PutMapping(value = "/{id}")
    public TipoCadastro update(@PathVariable Long id, @RequestBody TipoCadastro tipoCadastroAtualizado) {
        TipoCadastro existingTipoCadastro = repository.findById(id).orElse(null);

        if (existingTipoCadastro != null) {
            existingTipoCadastro.setName(tipoCadastroAtualizado.getName());
            return repository.save(existingTipoCadastro);
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            TipoCadastro deletedTipoCadastro = repository.findById(id).orElse(null);

            if (deletedTipoCadastro != null) {
                List<Cadastro> cadastros = cadastroRepository.findByTipoCadastro(deletedTipoCadastro);

                if (!cadastros.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.CONFLICT)
                            .body("Não é possível excluir o TipoCadastro com ID " + id +
                                    " porque há registros associados na tabela Cadastro.");
                }

                repository.deleteById(id);

                return ResponseEntity.ok("TipoCadastro com ID " + id + " foi deletado com sucesso.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("TipoCadastro com ID " + id + " não encontrado.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar TipoCadastro com ID " + id + ": " + e.getMessage());
        }
    }
}
