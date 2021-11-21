package com.murilo.producer.model;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    public Venda(Long id, String descricao, List<Produto> listaProduto, String idTransacao, String statusTransacao,
                 String numeroDoCartao, String codigoDeSeguranca) {

        this.id = id;
        this.descricao = descricao;
        this.listaProduto = listaProduto;
        this.idTransacao = idTransacao;
        this.statusTransacao = statusTransacao;
        this.numeroDoCartao = numeroDoCartao;
        this.codigoDeSeguranca = codigoDeSeguranca;
    }

    public Venda() {
    }

    private Long id;
    private String descricao;
    private List<Produto>  listaProduto = new ArrayList<>();
    private String idTransacao;
    private String statusTransacao;
    private String numeroDoCartao;
    private String codigoDeSeguranca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void setListaProduto(List<Produto> listaProduto) {
        this.listaProduto = listaProduto;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getStatusTransacao() {
        return statusTransacao;
    }

    public void setStatusTransacao(String statusTransacao) {
        this.statusTransacao = statusTransacao;
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public void setNumeroDoCartao(String numeroDoCartao) {
        this.numeroDoCartao = numeroDoCartao;
    }

    public String getCodigoDeSeguranca() {
        return codigoDeSeguranca;
    }

    public void setCodigoDeSeguranca(String codigoDeSeguranca) {
        this.codigoDeSeguranca = codigoDeSeguranca;
    }


}
