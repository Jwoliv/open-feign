package org.example.infrastructure.kafka;

import lombok.Setter;
import org.example.dto.RecordDto;
import org.example.service.SpecialRecordServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CoreListener {

    @Setter(onMethod = @__({@Autowired}))
    private SpecialRecordServiceI specialRecordService;

    @KafkaListener(topics = "${listener.config.topic.core-topic.name}", groupId = "default")
    public void listen(RecordDto record) {
        specialRecordService.saveSpecialRecord(record);
    }
}
