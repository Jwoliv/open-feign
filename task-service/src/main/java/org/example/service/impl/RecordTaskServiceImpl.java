package org.example.service.impl;

import lombok.Setter;
import org.example.dto.RecordDto;
import org.example.feign.TestCore;
import org.example.service.RecordTaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RecordTaskServiceImpl implements RecordTaskServiceI {

    @Setter(onMethod = @__({@Autowired}))
    private TestCore testCore;

    @Override
    public void saveRecord(Long id) {
        String title = testCore.getString(id) + " [extra task information]";
        RecordDto record = buildRecord(title);
        testCore.saveRecord(record);
    }

    private RecordDto buildRecord(String title) {
        return RecordDto.builder()
                .title(title)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
