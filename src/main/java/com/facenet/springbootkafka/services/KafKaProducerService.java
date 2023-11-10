/*
 * This class was created at 04/10/2022 11:33:05
 * FaceNet Company is owner of this class
 *
 * @author Bui Xuan Hieu
 *
 */

package com.facenet.springbootkafka.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafKaProducerService {
    private static final Logger log = LogManager.getLogger();

    @Value(value = "${spring.kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String message)
    {
        ListenableFuture<SendResult<String, String>> future
                = this.kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent message: " + message
                        + " with offset: " + result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message : " + message, ex);
            }
        });
    }
}

