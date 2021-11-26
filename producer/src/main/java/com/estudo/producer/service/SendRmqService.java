package com.estudo.producer.service;

import com.estudo.producer.model.Venda;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class SendRmqService {

    private final static String QUEUE_NAME = "processar_vendas";

    public void execute(Venda venda) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {
            processarFila(venda, factory);
        } catch (IOException | TimeoutException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void processarFila(Venda venda, ConnectionFactory factory) throws IOException, TimeoutException {
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        byte[] vendaBtyes = gerarBytes(venda);
        channel.basicPublish("", QUEUE_NAME, null, vendaBtyes);
        channel.close();
        connection.close();
    }

    private byte[] gerarBytes(Venda venda) {
        return SerializationUtils.serialize(venda);
    }
}
