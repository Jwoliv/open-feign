package org.example.task;

import lombok.Setter;
import org.example.service.RecordTaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RecordTask {
    @Setter(onMethod = @__({@Autowired}))
    private RecordTaskServiceI recordTaskService;

    @Scheduled(cron = "${task.save-special-task.cron}")
    public void taskRecord() {
        recordTaskService.saveRecord(new Random(100).nextLong());
    }
}
