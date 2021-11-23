package com.estudo.producer.controller;


import com.estudo.producer.model.Produtos;
import com.estudo.producer.model.Venda;
import com.estudo.producer.service.SendRmqService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Random;

@RestController
@RequestMapping("/vendas")
@AllArgsConstructor
public class VendaController {

    private SendRmqService sendRmqService;
    @PostMapping("/teste")
    public ResponseEntity<String> popularVenda() {

        Random random = new Random();
        Produtos produto1 = new Produtos();
        Produtos produto2 = new Produtos();

        produto1.setId(random.nextLong());
        produto1.setNome("PlayStation 5");
        produto1.setValor(1200.00);

        produto2.setId(random.nextLong());
        produto2.setNome("PlayStation 4");
        produto2.setValor(12030.00);

        Venda vendaCriada = Venda.builder()
                                    .id(random.nextLong())
                                    .descricao("Venda internet")
                                    .listaDeProdutos(Arrays.asList(produto1,produto2))
                                    .numeroCartaoCredito(random.toString())
                                    .StatusProcessamento("Pendente").build();
        sendRmqService.execute(vendaCriada);
        return ResponseEntity.ok("venda publicada na fila!");
    }
}
