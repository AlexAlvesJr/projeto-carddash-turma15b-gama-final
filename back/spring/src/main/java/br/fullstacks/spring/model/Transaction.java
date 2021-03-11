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
    private int id_transacao;

    @Column(name = "data_hora")
    private String data_hora;   // poderiamos usar LocalDate, mas optamos por usar String. Projeto não vai usar essa variável

    @Column(name = "dispositivo", nullable = false)
    private int dispositivo;

    @Column(name = "valor_solic", nullable = false)
    private double valor_solic;

    @Column(name = "valor_aut", nullable = false)
    private double valor_aut;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "ag_financeiro", nullable = false)
    private int ag_financeiro;

    @ManyToOne  // relacionamento da tabela / classe Transaction com AgFinanceiro
    @JoinColumn(name = "id_agente")    // nome da coluna que será criada no DB para relacionamento com AgFinanceiro
    private AgFinanceiro agFinanceiro;

    public int getId_transacao() {
        return id_transacao;
    }

    public void setId_transacao(int id_transacao) {
        this.id_transacao = id_transacao;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }

    public int getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(int dispositivo) {
        this.dispositivo = dispositivo;
    }

    public double getValor_solic() {
        return valor_solic;
    }

    public void setValor_solic(double valor_solic) {
        this.valor_solic = valor_solic;
    }

    public double getValor_aut() {
        return valor_aut;
    }

    public void setValor_aut(double valor_aut) {
        this.valor_aut = valor_aut;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAg_financeiro() {
        return ag_financeiro;
    }

    public void setAg_financeiro(int ag_financeiro) {
        this.ag_financeiro = ag_financeiro;
    }

    public AgFinanceiro getAgFinanceiro() {
        return agFinanceiro;
    }

    public void setAgFinanceiro(AgFinanceiro agFinanceiro) {
        this.agFinanceiro = agFinanceiro;
    }

}
