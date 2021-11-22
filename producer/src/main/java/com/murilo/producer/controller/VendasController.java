package com.murilo.producer.controller;

import com.murilo.producer.model.Produto;
import com.murilo.producer.model.Venda;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @PostMapping("/criar")
    public ResponseEntity<Void> postarVenda() {
        Random aleatorio = new Random();
        Long idAutomatica = aleatorio.nextLong() * 10;

        Produto produto1 = new Produto();
        produto1.setId(idAutomatica);
        produto1.setNome("Play station 5");
        produto1.setValor(300.0);
        Produto produto2 = new Produto();
        produto2.setId(idAutomatica);
        produto2.setNome("Play station 4");
        produto2.setValor(400.0);


        var venda = Venda.builder()
                .id(idAutomatica).descricao("Compra as 1 da tarde")
                .listaProduto(List.of(produto1,produto2))
                .idTransacao(idAutomatica.toString())
                .statusTransacao("PENDENTE")
                .numeroDoCartao("4040 3030 2020 2200")
                .codigoDeSeguranca("33")
                .build();

        return null;
    }
}
