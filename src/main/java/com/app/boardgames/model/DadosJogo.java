package com.app.boardgames.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "dados_jogo")
public class DadosJogo  {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_do_jogo")
    private String nomeDoJogo;
    private double preco;

    @Column(name ="url_imagem")
    private String urlImagem;
    private String descricao;
    private double nota;
    private String loja;


    public String getLoja() {
        return loja;
    }
    public void setLoja(String loja) {
        this.loja = loja;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
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

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

}

