package org.example.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RecordDto {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
}
