package com.studentappui.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@ComponentScan("com.studentappui.service")
public class StudentAppUI {
    public static void main(String[] args) {
        SpringApplication.run(StudentAppUI.class, args);
    }

}
