/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prj_rabbit_lpv;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Prj_rabbit_LPV {

    private final static String QUEUE_NAME = "cola1";

    public static void main(String[] args) throws IOException, TimeoutException {
        //envio de mensajes

        ConnectionFactory factory = new ConnectionFactory();
        Channel channel;
        factory.setHost("34.134.239.46");
        factory.setUsername("leydi");
        factory.setPassword("leydi123p");
        Connection connection = factory.newConnection();
        channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        String message = "Mensaje x";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("Enviado:" + message + "");

        System.out.println("FIN ENVÍO");

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println("[*] Waiting for messages, To exit press CTRL+C");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message1 = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println("[*] Received" + message1 + "");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
    }
}
