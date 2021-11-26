package com.estudo.consumer.Controller;

import com.estudo.consumer.service.RecvRmqService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
@AllArgsConstructor
public class CheckoutController {

    private RecvRmqService recvRmqService;

    @PostMapping("/teste")
    public ResponseEntity<String> popularCheckout(){
        return ResponseEntity.ok("status da venda alterado para processado");
    }

}
