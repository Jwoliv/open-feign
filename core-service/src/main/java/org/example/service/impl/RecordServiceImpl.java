package org.example.service.impl;

import lombok.Setter;
import org.example.dto.RecordDto;
import org.example.modal.Record;
import org.example.repository.RecordRepository;
import org.example.service.RecordTaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordTaskServiceI {

    @Setter(onMethod = @__({@Autowired}))
    private RecordRepository recordRepository;

    @Override
    public void saveRecord(RecordDto record) {
        Record recordEntity = Record.builder()
                .title(record.getTitle())
                .createdAt(record.getCreatedAt())
                .build();
        recordRepository.save(recordEntity);
    }
}
