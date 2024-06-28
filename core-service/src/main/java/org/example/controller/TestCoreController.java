package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/core")
public class TestCoreController {
    @GetMapping("/{id}")
    public String getString(@PathVariable("id") Long id) {
        return "string#%d".formatted(id);
    }
}
