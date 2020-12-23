package com.example.dummy_bpjs.rabbitmq;

import com.example.dummy_bpjs.model.Bpjs;
import com.example.dummy_bpjs.repository.BpjsRepositories;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

@Component
public class Consumer {

    @Autowired
    BpjsRepositories bpjsRepositories;
    private Producer producer;
    private String response;

    @RabbitListener(queues = "BankRequest")
    public void ApiRequest(Message message) throws IOException, TimeoutException {
        String request = new String(message.getBody(), StandardCharsets.UTF_8);
        Bpjs bpjs = bpjsRepositories.findBpjs(Integer.parseInt(request)).get();
        if (bpjs.getStatusPembayaran().equals("Belum Bayar")) {
            bpjs.setStatusPembayaran("Telah Terbayar");
            bpjsRepositories.save(bpjs);
            producer.sendToRestApi("Success");
        } else {
            producer.sendToRestApi("Gagal");

        }
    }
}