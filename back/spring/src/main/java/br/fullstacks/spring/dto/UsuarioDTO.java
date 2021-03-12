package br.fullstacks.spring.dto;

import br.fullstacks.spring.model.Usuario;

public class UsuarioDTO {
    private String nome;
    private String email;
    private String racf;
    private String linkFoto;

    public UsuarioDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.racf = usuario.getRacf();
        this.linkFoto = usuario.getLinkfoto();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRacf() {
        return racf;
    }

    public void setRacf(String racf) {
        this.racf = racf;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }
    
}
