package com.estudo.producer.service;

import com.estudo.producer.model.Venda;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeoutException;

@Service
public class SendRmqService {

    private final static String QUEUE_NAME = "processar_vendas";

    public void execute(Venda venda) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, serialize(venda));

        } catch (IOException | TimeoutException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public byte[] serialize(Venda venda) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(venda);
        return out.toByteArray();
    }
}
