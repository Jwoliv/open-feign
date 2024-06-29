package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dto.RecordDto;

public interface RecordTaskServiceI {
    void saveRecord(RecordDto recordDto);
}
