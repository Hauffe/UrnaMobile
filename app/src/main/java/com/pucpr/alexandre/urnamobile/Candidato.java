package com.pucpr.alexandre.urnamobile;

public class Candidato {

    private String nome;
    private Integer imagem;
    private Integer votos;

    public Candidato(String nome, Integer imagem) {
        this.nome = nome;
        this.imagem = imagem;
        this.votos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getImagem() {
        return imagem;
    }

    public void setImagem(Integer imagem) {
        this.imagem = imagem;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    public void receberVoto(){
        this.votos++;
    }
}
