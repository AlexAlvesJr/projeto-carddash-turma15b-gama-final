package br.fullstacks.spring.dto;

public class ContagemStatus {
    private String agente;
    private double volumeTransacional;
    private int status;
    private long count;

    public ContagemStatus(String agente, double volumeTransacional, int status, long count) {
        this.agente = agente;
        this.volumeTransacional = volumeTransacional;
        this.status = status;
        this.count = count;
    }

    public String getAgente() {
        return agente;
    }

    public void setAgente(String agente) {
        this.agente = agente;
    }

    public double getVolumeTransacional() {
        return volumeTransacional;
    }

    public void setVolumeTransacional(double volumeTransacional) {
        this.volumeTransacional = volumeTransacional;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }


}
