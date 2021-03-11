package br.fullstacks.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fullstacks.spring.dto.UsuarioDTO;
import br.fullstacks.spring.model.Usuario;
import br.fullstacks.spring.repository.UsuarioRepo;

// Controller não acessa o DB diretamente, usa uma camada intermediária (repositório) para chegar no DB

@RestController
@CrossOrigin("*")    // aceita requisições de qualuqer origem / lugar
@RequestMapping("/user") //
public class UsuarioController {
    
    @Autowired // gerenciada no DB pelo JPA 
    private UsuarioRepo repo;

    @GetMapping("/id/{id}") // {id} é o nome da variável
    public ResponseEntity<UsuarioDTO> obterUsuarioPorId(@PathVariable int id) {    // referencia a variável {id} do GgetMapping
        
        Usuario usuarioEncontrado = repo.findById(id).orElse(null); // findById busca pela chave primária
        
        if (usuarioEncontrado != null) {
            UsuarioDTO userDTO = new UsuarioDTO(usuarioEncontrado); // usando DTO
            return ResponseEntity.ok(userDTO);    // ok = 200
        }
        
        return ResponseEntity.notFound().build();   // notFound = 404 quando não tem conteudo dentro do .ok /.notFound precisa do .build
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody Usuario user) {    // no corpo da requisição virá um usuário
        Usuario userFound = repo.findByEmailOrRacf(user.getEmail(), user.getRacf());

        if (userFound != null) {
            if (user.getSenha().equals(userFound.getSenha())) {                
                UsuarioDTO userDTO = new UsuarioDTO(userFound);
                return ResponseEntity.ok(userDTO);
            }
        }
        return ResponseEntity.status(404).build();  // Not Found
    }

}
