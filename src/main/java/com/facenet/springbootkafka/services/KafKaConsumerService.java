/*
 * This class was created at 04/10/2022 11:25:05
 * FaceNet Company is owner of this class
 *
 * @author Bui Xuan Hieu
 *
 */

package com.facenet.springbootkafka.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumerService {
    private static final Logger log = LogManager.getLogger();

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info(String.format("Message recieved -> %s", message));
    }

}

