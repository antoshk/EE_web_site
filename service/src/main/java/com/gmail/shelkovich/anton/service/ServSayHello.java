package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.HelloSayable;
import com.gmail.shelkovich.anton.repository.RepSayHello;

public class ServSayHello implements HelloSayable {
    public String sayHello() {
        return (new RepSayHello().sayHello())+"Hello from service!\n";
    }
}
