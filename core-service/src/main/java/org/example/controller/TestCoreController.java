package org.example.controller;

import lombok.Setter;
import org.example.dto.RecordDto;
import org.example.service.RecordTaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/core")
public class TestCoreController {

    @Setter(onMethod = @__({@Autowired}))
    private RecordTaskServiceI recordTaskService;

    @GetMapping("/{id}")
    public String getString(@PathVariable("id") Long id) {
        return "string#%d".formatted(id);
    }

    @PostMapping("/save-record")
    public void saveRecord(@RequestBody RecordDto record) {
        recordTaskService.saveRecord(record);
    }

    @PostMapping("/save-special-record")
    public void saveSpecialRecord(@RequestBody RecordDto recordDto) {
        recordTaskService.saveSpecialRecord(recordDto);
    }
}
