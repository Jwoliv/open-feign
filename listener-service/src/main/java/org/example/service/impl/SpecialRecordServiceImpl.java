package org.example.service.impl;

import lombok.Setter;
import org.example.dto.RecordDto;
import org.example.feign.TestCore;
import org.example.service.SpecialRecordServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialRecordServiceImpl implements SpecialRecordServiceI {

    @Setter(onMethod = @__({@Autowired}))
    private TestCore testCore;

    @Override
    public void saveSpecialRecord(RecordDto recordDto) {
        testCore.saveSpecialRecord(recordDto);
    }

}
