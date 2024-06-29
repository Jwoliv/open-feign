package org.example.infrastructure.kafka;

import org.example.dto.RecordDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CoreListener {

    @KafkaListener(topics = "${listener.config.topic.core-topic.name}", groupId = "default")
    public void listen(RecordDto element) {
        System.out.println(element);
    }
}
