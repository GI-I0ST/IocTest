package com.ghost.iocsecondtest;

import org.springframework.beans.factory.annotation.Autowired;

public class FirstService {
    private SecondService secondService;

    public FirstService(@Autowired SecondService secondService) {
        this.secondService = secondService;
    }

    public void printStr() {
        System.out.println(secondService.getStr());
    }
}
