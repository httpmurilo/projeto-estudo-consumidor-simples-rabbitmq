package com.estudo.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
    private Long id;
    private String descricao;
    private List<Produtos> listaDeProdutos = new ArrayList<>();
    private String numeroCartaoCredito;
    private String StatusProcessamento;
}
