package br.fullstacks.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fullstacks.spring.model.Compra;
import br.fullstacks.spring.repository.CompraRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/compra")
public class CompraController {
    
    @Autowired
    private CompraRepo repo;

    @GetMapping("/all")
    public ResponseEntity<List<Compra>> listarCompras() {
        List<Compra> lista = (List<Compra>) repo.findAll();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/value/{valor}")
    public ResponseEntity<List<Compra>> listarComprasComValorMaiorQue(@PathVariable double valor) {
        List<Compra> lista = (List<Compra>) repo.findByValorGreaterThan(valor);

        return ResponseEntity.ok(lista);
    }

}
