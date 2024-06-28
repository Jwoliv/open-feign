package org.example.service.impl;

import lombok.Setter;
import org.example.feign.TestCore;
import org.example.modal.Record;
import org.example.repository.RecordRepository;
import org.example.service.RecordTaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RecordTaskServiceImpl implements RecordTaskServiceI {

    @Setter(onMethod = @__({@Autowired}))
    private TestCore testCore;
    @Setter(onMethod = @__({@Autowired}))
    private RecordRepository recordRepository;

    @Override
    public void saveRecord(Long id) {
        String title = testCore.getString(id) + " [extra task information]";
        Record record = buildRecord(title);
        recordRepository.save(record);
    }

    private Record buildRecord(String title) {
        return Record.builder()
                .title(title)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
