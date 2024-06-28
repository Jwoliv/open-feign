package org.example.controller;

import lombok.Setter;
import org.example.service.TestMiddleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/middle")
public class TestMiddleController {

    @Setter(onMethod = @__({@Autowired}))
    private TestMiddleServiceI testMiddleService;

    @GetMapping("/{id}")
    public String getString(@PathVariable("id") Long id) {
        return testMiddleService.getString(id);
    }
}
