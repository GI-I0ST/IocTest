package com.ghost.iocthirdtest;

public class FirstService {
    private SecondService secondService;

    public FirstService(SecondService secondService) {
        this.secondService = secondService;
    }

    public void printStr() {
        System.out.println(secondService.getStr());
    }
}
