package com.murilo.producer.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Venda {

    private  Long id;
    private  String descricao;
    private List<Produto>  listaProduto = new ArrayList<>();
    private  String idTransacao;
    private  String statusTransacao;
    private  String numeroDoCartao;
    private  String codigoDeSeguranca;


}
