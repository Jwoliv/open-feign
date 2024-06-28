package org.example.feign;

import org.example.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "${feign.client.config.core-service.name}",
        url="${feign.client.config.core-service.url}",
        configuration = FeignConfig.class
)
public interface TestCore {
    @GetMapping("/{id}")
    String getString(@PathVariable("id") Long id);
}
