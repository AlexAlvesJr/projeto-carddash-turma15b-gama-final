package br.fullstacks.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fullstacks.spring.dto.ContagemStatus;
import br.fullstacks.spring.repository.TransactionRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/agente")
public class TransactionController {
    
    @Autowired
    private TransactionRepo repo;

    @GetMapping("/count/{idAgente}")
    public ResponseEntity<List<ContagemStatus>> listarVolumeTransacional(@PathVariable int idAgente) {
        List<ContagemStatus> lista = repo.countStatusByAgent(idAgente);

        return ResponseEntity.ok(lista);
    }
}
