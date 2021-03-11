package br.fullstacks.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// pessoa que faz login, acessa e usa o sistema

@Entity // javax.persistence classe mapeada no banco de dados
@Table(name = "usuario")    // nome da tabela no banco de dados
public class Usuario {

    @Id // indica que é chave primária no banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera sequencia automaticamente na estratégia 1, 2, 3...
    @Column(name = "id")    // nome da coluna no banco de dados
    private int id;

    @Column(name = "nome", length = 150, nullable = false)  // coluna nome com registro em até 150 varchar not null 
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false, unique = true) // coluna cpf para registros até 11 varchar not null e sem duplicidade
    private String cpf;

    @Column(name = "email", length = 30, nullable = false, unique = true)   // coluna email para registros até 30 varchar not null e sem duplicidade
    private String email;

    @Column(name = "senha", length = 20, nullable = false)  // coluna senha para registros até 20 varchar not null e sem duplicidade
    private String senha;

    @OneToMany(mappedBy = "usuario")    // relacionamento da tabela / classe Usuário com Compra
    @JsonIgnoreProperties("usuario")    // não exibe na tela. Não retorna o atributos usuario da tabela / classe Compras para evitar erro de loop
    private List<Compra> compras;    // por serem várias compras (OneToMany), usamos o List

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

}
