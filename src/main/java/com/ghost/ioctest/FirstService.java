package com.ghost.ioctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstService {
    @Autowired
    private SecondService secondService;
}
