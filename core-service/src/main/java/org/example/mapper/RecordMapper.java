package org.example.mapper;

import org.example.dto.RecordDto;
import org.example.modal.Record;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecordMapper {
    Record mapToEntity(RecordDto record);
    RecordDto mapToDto(Record record);
}
