package org.example.feign;

import org.example.config.ListenerServiceConfig;
import org.example.dto.RecordDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "${feign.client.config.core-service.name}",
        url="${feign.client.config.core-service.url}",
        configuration = ListenerServiceConfig.class
)
public interface TestCore {

    @PostMapping("/save-special-record")
    public void saveSpecialRecord(@RequestBody RecordDto recordDto);
}
