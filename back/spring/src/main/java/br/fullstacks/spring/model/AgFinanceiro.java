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

@Entity
@Table(name = "mtb310_ag_financeiro")
public class AgFinanceiro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agente")
    private int id_agente;

    @Column(name = "nome_agente", length = 100, nullable = false)
    private String nome_agente;

    @Column(name = "volume_transacional", nullable = false)
    private double volume_transacional;
        
    @OneToMany(mappedBy = "agFinanceiro")    // relacionamento da tabela / classe AgFinanceiro com Transaction
    @JsonIgnoreProperties("agFinanceiro")    // não exibe na tela. Não retorna o atributos usuario da tabela / classe Compras para evitar erro de loop
    private List<Transaction> transactions;    // por serem várias compras (OneToMany), usamos o List
    
    public int getId_agente() {
        return id_agente;
    }

    public void setId_agente(int id_agente) {
        this.id_agente = id_agente;
    }

    public String getNome_agente() {
        return nome_agente;
    }

    public void setNome_agente(String nome_agente) {
        this.nome_agente = nome_agente;
    }

    public double getVolume_transacional() {
        return volume_transacional;
    }

    public void setVolume_transacional(double volume_transacional) {
        this.volume_transacional = volume_transacional;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
