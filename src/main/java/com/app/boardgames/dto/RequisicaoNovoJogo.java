package com.app.boardgames.dto;

import com.app.boardgames.model.DadosJogo;
import org.hibernate.validator.constraints.URL;


import javax.validation.constraints.NotBlank;

//DTO clase que serve para receber infos do objetos
//deve ser o mesmo name dos formularios

public class RequisicaoNovoJogo {

    @NotBlank//NotBlank.requisicaoNovoJogo.nomeDoJogo = não pode estar em branco
    private String nomeDoJogo;

    private double preco;
    @NotBlank
    private String urlImagem;
    @NotBlank
    private String descricao;

    private double nota;
    @NotBlank
    private String loja;

    public String getNomeDoJogo() {
        return nomeDoJogo;
    }
    public void setNomeDoJogo(String nomeDoJogo) {
        this.nomeDoJogo = nomeDoJogo;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getUrlImagem() {
        return urlImagem;
    }
    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    public String getLoja() {
        return loja;
    }
    public void setLoja(String loja) {
        this.loja = loja;
    }
    public DadosJogo toDadosJogos() {
        DadosJogo dadosJogo = new DadosJogo();

        dadosJogo.setNomeDoJogo(nomeDoJogo);
        dadosJogo.setPreco(preco);
        dadosJogo.setUrlImagem(urlImagem);
        dadosJogo.setDescricao(descricao);
        dadosJogo.setLoja(loja);
        dadosJogo.setNota(nota);

        return dadosJogo;
    }

}
