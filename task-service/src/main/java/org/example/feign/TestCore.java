package org.example.feign;

import org.example.config.FeignConfig;
import org.example.dto.RecordDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "${feign.client.config.core-service.name}",
        url="${feign.client.config.core-service.url}",
        configuration = FeignConfig.class
)
public interface TestCore {
    @GetMapping("/{id}")
    String getString(@PathVariable("id") Long id);
    @PostMapping("/save-record")
    void saveRecord(@RequestBody RecordDto record);
}
