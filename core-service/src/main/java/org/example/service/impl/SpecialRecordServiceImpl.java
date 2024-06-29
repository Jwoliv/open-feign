package org.example.service.impl;

import lombok.Setter;
import org.example.dto.RecordDto;
import org.example.modal.SpecialRecord;
import org.example.repository.SpecialRecordRepository;
import org.example.service.SpecialRecordServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialRecordServiceImpl implements SpecialRecordServiceI {

    @Setter(onMethod = @__({@Autowired}))
    private SpecialRecordRepository specialRecordRepository;

    @Override
    public void saveSpecialRecord(RecordDto recordDto) {
        SpecialRecord specialRecord = buildSpecialRecord(recordDto);
        specialRecordRepository.save(specialRecord);
    }

    private static SpecialRecord buildSpecialRecord(RecordDto recordDto) {
        return new SpecialRecord(recordDto.getTitle(), recordDto.getCreatedAt(), recordDto.getId());
    }
}
