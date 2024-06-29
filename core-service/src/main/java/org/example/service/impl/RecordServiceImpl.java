package org.example.service.impl;

import lombok.Setter;
import lombok.SneakyThrows;
import org.example.dto.RecordDto;
import org.example.modal.Record;
import org.example.modal.SpecialRecord;
import org.example.repository.RecordRepository;
import org.example.repository.SpecialRecordRepository;
import org.example.service.RecordTaskServiceI;
import org.example.service.SpecialRecordServiceI;
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
    private SpecialRecordServiceI specialRecordService;
    @Setter(onMethod = @__({@Autowired}))
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    @SneakyThrows
    public void saveRecord(RecordDto record) {
        Record recordEntity = buildRecord(record);
        Record savedRecord = recordRepository.save(recordEntity);
        sendToTopic(savedRecord);
    }

    @Override
    public void saveSpecialRecord(RecordDto recordDto) {
        specialRecordService.saveSpecialRecord(recordDto);
    }

    private void sendToTopic(Record savedRecord) {
        if (isSpecialRecord(savedRecord)) {
            RecordDto recordDto = buildRecordDto(savedRecord);
            kafkaTemplate.send(topicName, recordDto);
        }
    }

    private Record buildRecord(RecordDto record) {
        return new Record(record.getTitle(), record.getCreatedAt());
    }

    private Boolean isSpecialRecord(Record savedRecord) {
        return savedRecord.getId() % 2 == 0;
    }

    private RecordDto buildRecordDto(Record savedRecord) {
        return RecordDto.builder()
                .id(savedRecord.getId())
                .title(savedRecord.getTitle())
                .createdAt(savedRecord.getCreatedAt())
                .build();
    }

}
