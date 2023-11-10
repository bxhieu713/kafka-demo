/*
 * This class was created at 04/10/2022 11:44:35
 * FaceNet Company is owner of this class
 *
 * @author Bui Xuan Hieu
 *
 */

package com.facenet.springbootkafka.controllers;

import com.facenet.springbootkafka.services.KafKaProducerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    private static final Logger log = LogManager.getLogger();
    @Autowired
    private KafKaProducerService kafkaProducerService;
    @GetMapping("/{message}")
    public String sendMessageToKafkaTopic(@PathVariable String message) {
        log.info("Message: " + message);
        this.kafkaProducerService.sendMessage(message);
        return "Message sent to the Kafka Topic test Successfully";
    }
}

