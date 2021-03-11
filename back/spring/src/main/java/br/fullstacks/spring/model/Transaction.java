package br.fullstacks.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mtb310_transaction")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao")
    private int idTransacao;

    @Column(name = "data_hora")
    private String dataHora;   // poderiamos usar LocalDate, mas optamos por usar String. Projeto não vai usar essa variável

    @Column(name = "dispositivo", nullable = false)
    private int dispositivo;

    @Column(name = "valor_solic", nullable = false)
    private double valorSolic;

    @Column(name = "valor_aut", nullable = false)
    private double valorAut;

    @Column(name = "status", nullable = false)
    private int status;

    @ManyToOne  // relacionamento da tabela / classe Transaction com AgFinanceiro
    @JoinColumn(name = "ag_financeiro")    // nome da coluna que será criada no DB para relacionamento com AgFinanceiro
    private AgFinanceiro agFinanceiro;

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public int getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(int dispositivo) {
        this.dispositivo = dispositivo;
    }

    public double getValorSolic() {
        return valorSolic;
    }

    public void setValorSolic(double valorSolic) {
        this.valorSolic = valorSolic;
    }

    public double getValorAut() {
        return valorAut;
    }

    public void setValorAut(double valorAut) {
        this.valorAut = valorAut;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AgFinanceiro getAgFinanceiro() {
        return agFinanceiro;
    }

    public void setAgFinanceiro(AgFinanceiro agFinanceiro) {
        this.agFinanceiro = agFinanceiro;
    }
}
