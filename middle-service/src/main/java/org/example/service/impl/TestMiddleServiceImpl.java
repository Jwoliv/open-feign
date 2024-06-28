package org.example.service.impl;

import lombok.Setter;
import org.example.feign.TestCore;
import org.example.service.TestMiddleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestMiddleServiceImpl implements TestMiddleServiceI {

    @Setter(onMethod = @__({@Autowired}))
    private TestCore testCore;

    @Override
    public String getString(Long id) {
        return testCore.getString(id) + " [extra middle information]";
    }
}
