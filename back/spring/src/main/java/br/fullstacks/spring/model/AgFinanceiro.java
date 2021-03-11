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
    private int idAgente;

    @Column(name = "nome_agente", length = 100, nullable = false)
    private String nomeAgente;

    @Column(name = "volume_transacional", nullable = false)
    private double volumeTransacional;
        
    @OneToMany(mappedBy = "agFinanceiro")    // relacionamento da tabela / classe AgFinanceiro com Transaction
    @JsonIgnoreProperties("agFinanceiro")    // não exibe na tela. Não retorna o atributos usuario da tabela / classe Compras para evitar erro de loop
    private List<Transaction> transactions;    // por serem várias compras (OneToMany), usamos o List

    public int getIdAgente() {
        return idAgente;
    }

    public void setIdAgente(int idAgente) {
        this.idAgente = idAgente;
    }

    public String getNomeAgente() {
        return nomeAgente;
    }

    public void setNomeAgente(String nomeAgente) {
        this.nomeAgente = nomeAgente;
    }

    public double getVolumeTransacional() {
        return volumeTransacional;
    }

    public void setVolumeTransacional(double volumeTransacional) {
        this.volumeTransacional = volumeTransacional;
    }
    
}
