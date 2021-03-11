package br.fullstacks.spring.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "compra")
public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "descricao", length = 200, nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private double valor;

    @Column(name = "data")
    private LocalDate data;

    @ManyToOne  // relacionamento da tabela / classe Compra com Usuário
    @JoinColumn(name = "id_usuario")    // nome da coluna que será criada no DB para relacionamento com Usuario
 // @JsonIgnoreProperties("compras")    // não exibe na tela. Não retorna o atributos compras da tabela / classe Usuario para evitar erro de loop
    @JsonIgnoreProperties({"compras","senha"})    // {} permite informar um conjunto de informações como se fosse apenas uma informação
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


}
