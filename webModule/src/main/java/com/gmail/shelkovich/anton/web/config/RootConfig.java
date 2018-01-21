package com.gmail.shelkovich.anton.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@ComponentScan(basePackages={   "com.gmail.shelkovich.anton.web.config",
        "com.gmail.shelkovich.anton.repository.dao",
        "com.gmail.shelkovich.anton.service"})
public class RootConfig {




}
