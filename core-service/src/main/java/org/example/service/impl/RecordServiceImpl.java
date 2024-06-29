package org.example.service.impl;

import lombok.Setter;
import lombok.SneakyThrows;
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
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    @SneakyThrows
    public void saveRecord(RecordDto record) {
        Record recordEntity = Record.builder()
                .title(record.getTitle())
                .createdAt(record.getCreatedAt())
                .build();
        Record savedRecord = recordRepository.save(recordEntity);
        if (savedRecord.getId() % 2 == 0) {
            RecordDto recordDto = RecordDto.builder()
                    .id(savedRecord.getId())
                    .title(savedRecord.getTitle())
                    .createdAt(savedRecord.getCreatedAt())
                    .build();
            kafkaTemplate.send(topicName, recordDto);
        }
    }
}
