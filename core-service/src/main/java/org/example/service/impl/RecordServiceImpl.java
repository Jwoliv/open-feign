package org.example.service.impl;

import lombok.Setter;
import org.example.dto.RecordDto;
import org.example.modal.Record;
import org.example.repository.RecordRepository;
import org.example.service.RecordTaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordTaskServiceI {

    @Value("${listener.config.topic.core-topic.name}")
    private String topicName;

    @Setter(onMethod = @__({@Autowired}))
    private RecordRepository recordRepository;
    @Setter(onMethod = @__({@Autowired}))
    private KafkaTemplate<String, String> kafkaTemplate;


    @Override
    public void saveRecord(RecordDto record) {
        Record recordEntity = Record.builder()
                .title(record.getTitle())
                .createdAt(record.getCreatedAt())
                .build();
        Record savedRecord = recordRepository.save(recordEntity);
        if (savedRecord.getId() % 2 == 0) {
            kafkaTemplate.send(topicName, savedRecord.toString());
        }
    }
}
